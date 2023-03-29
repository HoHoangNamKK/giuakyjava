<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page!</h1>
	<form action="LoginServlet" method="post">
		Username: <input type="text" name="txtUsername" value="" /><br><br>
		Password: <input type="password" name="txtPassword" value="" /><br><br>
		<input type="submit" value="Login" name="btAction" />
		<input type="reset" value="Reset" />
	</form>
</body>
</html>