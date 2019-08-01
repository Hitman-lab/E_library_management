<%@page import="com.dao.LibraryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
</head>
<body>
	<jsp:useBean id="issue_obj" class="com.bean_pages.IssueBook"></jsp:useBean>
	<jsp:setProperty property="*" name="issue_obj" />

	<%
		int status = LibraryDao.issueBook(issue_obj);
		if (status > 0) {
			response.sendRedirect("issueBookSuccess.jsp");
		} else {
			response.sendRedirect("issueBookFailure.jsp");
		}
	%>

</body>
</html>