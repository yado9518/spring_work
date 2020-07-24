<%-- 웹브라우저 출력되는 문자, 태그, 언어코딩 타입 설정 -> 이것 안하면 브라우저에 출력되는 한글이 깨짐. --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
