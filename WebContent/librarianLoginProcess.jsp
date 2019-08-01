<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Login</title>
</head>
<body>
	<%
		RequestDispatcher rd = request.getRequestDispatcher("LibrarianLoginServlet");
		rd.include(request, response);
	%>


</body>
</html>