<%@page import="com.dao.LibraryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<jsp:useBean id="book_obj" class="com.bean_pages.AddBook"></jsp:useBean>
	<jsp:setProperty property="*" name="book_obj" />


	<%
		int status = LibraryDao.addBook(book_obj);
		if (status > 0) {
			response.sendRedirect("addBookSuccess.jsp");
		} else {
			response.sendRedirect("addBookFailure.jsp");
		}
	%>

</body>
</html>