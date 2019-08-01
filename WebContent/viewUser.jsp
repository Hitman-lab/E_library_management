<%@page import="com.dao.LibraryDao"%>
<%@page import="com.bean_pages.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<style type="text/css">
.w3-bar.w3-light.w3-card-4 {
	color: black;
}
</style>
</head>
<body>

	<%
		List<User> l1 = LibraryDao.getAllRecords();
		request.setAttribute("my_list", l1);
	%>

	<div class="w3-top">
		<div class="w3-bar w3-light-grey w3-large w3-card">
			<a href="adminPage.jsp"
				class="w3-bar-item w3-button w3-mobile w3-red ">Home</a> <a
				href="viewUser.jsp" class="w3-bar-item w3-button w3-mobile">View
				Librarian</a> <a href="AdminLogout"
				class="w3-bar-item w3-button w3-mobile w3-right">Logout</a>
		</div>
	</div>


	<div style="margin-top: 45px;">
		<%
			if (l1.size() == 0) {
		%>
		<div class="w3-display-container">
			<div class="w3-card-2">
				<div class="w3-container w3-center w3-teal">
					<h2>No Records Found</h2>
				</div>
			</div>
		</div>
		<%
			return;
			}
		%>
	</div>

	<div class="container" style="margin-top: 100px">
		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone No</th>
				<!-- 	<th>EDIT</th> -->
				<th>DELETE</th>
			</tr>

			<c:forEach var="e" items="${my_list }">
				<tr>
					<td>${e.getId()}</td>
					<td>${e.getName()}</td>
					<td>${e.getEmail()}</td>
					<td>${e.getPassword()}</td>
					<td>${e.getPhoneno()}</td>
					<%-- <td><a class="btn btn-info"
						href="editform.jsp?id=${e.getId()}">Edit</a></td> --%>
					<td><a class="btn btn-danger"
						href="DeleteUser?id=${e.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>