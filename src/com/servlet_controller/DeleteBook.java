package com.servlet_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LibraryDao;

public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBook() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cellno = request.getParameter("cellno");
		int status = LibraryDao.deleteBook(cellno);
		response.sendRedirect("ViewBook.jsp");

	}

}
