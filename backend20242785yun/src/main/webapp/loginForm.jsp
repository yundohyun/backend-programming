<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	
	<% 
		Object user = application.getAttribute("user");
		Object message = application.getAttribute("message");
		if (user != null) {
	%>
		<p><%= user %>님, 안녕하세요!</p>
		<form method="post" action="logout.do">
			<input type="submit" value="로그아웃">
		</form>
	<% } else { if (message != null) { %>
		<p style="color: red;">
			<%= message %>
		</p>
	<% application.removeAttribute("message"); } %>
		<form method="post" action="login.do">
			아이디 : <input type="text" name="id"><br>
			암호 : <input type="password" name="password"><br>
			<input type="submit">
			<input type="reset">
		</form>
	<% } %>
</body>
</html>