<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/jsp/cmm/decorator/taglib.jsp"/>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>개발테스트</title>
<sitemesh:write property="head" />
</head>
<body>
<div id="wrap">
	<div style="font-size:20px">sub-layout.jsp</div>
	<sitemesh:write property="body" />
	<div style="font-size:20px">sub-layout.jsp</div>
</div>
</body>
</html>