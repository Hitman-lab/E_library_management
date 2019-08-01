<%@page import="com.dao.LibraryDao"%>
<%@page import="com.bean_pages.IssueBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Issued Book</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		List<IssueBook> l = LibraryDao.viewIssuedBook();
		request.setAttribute("my_list", l);
	%>

	<div class="container" style="margin-top: 100px">
		<table class="table table-striped">
			<tr>
				<th>Cell No</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Mobile</th>
				<th>Issued Date</th>
				<th>Return Status</th>
			</tr>

			<c:forEach var="e" items="${my_list}">
				<tr>
					<td>${e.getCellno() }</td>
					<td>${e.getStudentid() }</td>
					<td>${e.getStudentname() }</td>
					<td>${e.getStudentmobile() }</td>
					<td>${e.getIssuedate() }</td>
					<td>${e.getReturnstatus() }</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>