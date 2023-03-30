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
	<h1>
		<font color="red">Welcome, ${sessionScope.USER}</font>
	</h1>
	<h1>Search Page!</h1>
	<form action="SearchServlet" method="post">
		Search value<input type="text" name="txtSearchValue"
			value="${param.txtSearchValue}" /><br> <input type="submit"
			value="Search" />
	</form>
	<br>
	<c:set var="searchValue" value="${param.txtSearchValue}" />
	<c:if test="${not empty searchValue}">
		<!-- hien ra search -->
		<p>-------------------------------------------------------------</p>
		<c:set var="result" value="${requestScope.SEARCHRESULT}" />
		<c:if test="${not empty result}">
			<table border="1">
				<thead>
					<tr>
						<th>No.</th>
						<th>Username</th>
						<th>Password</th>
						<th>Lastname</th>
						<th>Roles</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${result}" varStatus="counter">
						<tr>
							<td>
								${counter.count}
							</td>
							<td>
								${dto.username}
								<input type="hidden" name="txtUsername" value="${dto.username}" />
							</td>
							<td>
								${dto.password}
								<input type="text" name="txtPassword" value="${dto.password}" />
							</td>
							<td>
								${dto.lastname}
							</td>
							<td>
								
								<input type="checkbox" name="checkAdmin" value="ADMIN" 
									<c:if test="${dto.role}">checked="checked"</c:if>
								/>
							</td>
							
							<!-- nut -->
							<td><a href="DeleteServlet?username=${dto.username}&lastSearchValue=${param.txtSearchValue}">Delete</a></td>
							<td><a href="UpdateServlet?username=${dto.username}&lastSearchValue=${param.txtSearchValue}">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty result}">
			<h2>No record is matched!!!</h2>
		</c:if>
		<p>-------------------------------------------------------------</p>
	</c:if>

</body>
</html>