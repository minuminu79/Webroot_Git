package egovframework.mwave.cmm.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.rte.fdl.property.EgovPropertyService;

@Component
public class FrontInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor{
	
	private static final Logger LOG = LoggerFactory.getLogger(FrontInterceptor.class);

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.KOREA);
		
		String uri 		= request.getRequestURI();														// 접속URI
		long lngPreDtm	= Long.parseLong(sdf.format(new Date()));										// 접속일시
		request.setAttribute("lngPreDtm", lngPreDtm);
		
		LOG.debug("preHandle URI[" + uri + "] lngPreDtm [" + lngPreDtm + "]");
		return true;
		
	}
 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.KOREA);
		
		String uri 		= request.getRequestURI();														// 접속URI
		long lngPreDtm	= (Long) request.getAttribute("lngPreDtm");										// 접속일시
		long lngPostDtm	= Long.parseLong(sdf.format(new Date()));										// 처리일시
		long lngTermDtm	= lngPostDtm - lngPreDtm;														// 처리일시
		
		
		LOG.debug("postHandle URI[" + uri + "] lngPreDtm[" + lngPreDtm + "] lngPostDtm[" + lngPostDtm + "] Term[" + (lngTermDtm) + "]");
		
	}
 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
