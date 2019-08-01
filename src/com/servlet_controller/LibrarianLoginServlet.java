package com.servlet_controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LibraryDao;

public class LibrarianLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LibrarianLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String pass = request.getParameter("password");

		boolean status = LibraryDao.LibrarianValidate(username, pass);
		if (status) {

			Cookie ck = new Cookie("librarian", "librarian_logged_in");
			response.addCookie(ck);

			RequestDispatcher rd = request.getRequestDispatcher("LibrarianLoginSuccess.jsp");
			rd.forward(request, response);
		} else {
			request.getRequestDispatcher("LibrarianLoginError.jsp").include(request, response);
		}
	}

}
