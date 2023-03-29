<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<font color="red">Welcome, ${sessionScope.USER}</font>
	</h1>
	<h1>Search Page!</h1>
	<form action="SearchServlet" method="post">
		Search value<input type="text" name="txtSearchValue" value="" /><br>
		<input type="submit" value="Search" />
	</form>
</body>
</html>