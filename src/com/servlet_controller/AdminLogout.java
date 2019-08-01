package com.servlet_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLogout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] ck = request.getCookies();
		if (ck == null) {
			response.sendRedirect("logoutError.html");
		} else {
			Cookie c = new Cookie("admin", "");
			c.setMaxAge(0);
			response.addCookie(c);
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
