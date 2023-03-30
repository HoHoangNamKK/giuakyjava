<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="text-align: left; margin-left: 500px">
		<h1>Update Account</h1>
		<form action="SaveUpdateServlet" method="post">
			<c:set var="lastSearchValue" value="${requestScope.lastSearchValue}"/>
			<c:set var="account" value="${requestScope.ac}" />
			<c:if test="${not empty account}">
					Username:
					<input type="text" readonly="readonly" name="txtUsername" value="${account.username}" />
				<br>
				<br>
					Password:
					<input type="password" name="txtPassword" value="${account.password}" />
				<br>
				<br>
					Lastname:
					<input type="text" name="txtLastname" value="${account.lastname}" />
				<br>
				<br>
					Admin:
					<input type="checkbox" name="checkAdmin" value="ADMIN" />
					<c:if test="${dto.role}">checked="checked"</c:if>
				<br>
				<br>
				<input type="text" hidden="true" name="lastSearchValue" value="${lastSearchValue}" />
				<input type="submit" name="button" value="Save" />
				<input type="submit" name="button" value="Cancel" />
			</c:if>
		</form>
	</div>

</body>
</html>