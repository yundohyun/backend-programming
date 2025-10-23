<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Object user = application.getAttribute("user");
	%>
	<h3>메뉴 : <a href="index.jsp">홈</a> <a href="intro.jsp">학교소개</a> <% out.print(user == null ? "회원가입" : "내정보"); %></h3>
</body>
</html>