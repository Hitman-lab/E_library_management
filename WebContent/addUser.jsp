<%@page import="com.dao.LibraryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding User</title>
</head>
<body>

	<jsp:useBean id="user_obj" class="com.bean_pages.User"></jsp:useBean>
	<jsp:setProperty property="*" name="user_obj" />


	<%
		int status = LibraryDao.userFormDate(user_obj);
		if (status > 0) {
			response.sendRedirect("addUserSuccess.jsp");
		} else {
			response.sendRedirect("addUserError.jsp");
		}
	%>

</body>
</html>