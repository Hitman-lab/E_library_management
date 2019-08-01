package com.servlet_controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LibraryDao;

public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReturnBook() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String cellNo = request.getParameter("cellno");
		String s_id = request.getParameter("studentid");

		int id = Integer.parseInt(s_id);

		int status = LibraryDao.returnBook(cellNo, id);
		if (status > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("returnSuccess.jsp");
			rd.forward(request, response);
		} else {
			request.getRequestDispatcher("returnFailure.jsp").include(request, response);
		}

	}

}
