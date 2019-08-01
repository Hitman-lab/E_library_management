<%@page import="com.dao.LibraryDao"%>
<%@page import="com.bean_pages.AddBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Book</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		List<AddBook> e1 = LibraryDao.viewBook();
		request.setAttribute("view_list", e1);
	%>

	<div class="container" style="margin-top: 100px">

		<table class="table table-striped">
			<tr>
				<th>Cell No</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Publisher</th>
				<th>Quantity</th>
				<th>Issued</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="e" items="${view_list}">
				<tr>
					<td>${e.getCellNo()}</td>
					<td>${e.getBookName()}</td>
					<td>${e.getAuthorName()}</td>
					<td>${e.getPublisher()}</td>
					<td>${e.getQuantity()}</td>
					<td>${e.getIssued()}</td>
					<td><a class="btn btn-danger"
						href="DeleteBook?cellno=${e.getCellNo()}">Delete</a></td>
				</tr>
			</c:forEach>


		</table>

	</div>
</body>
</html>