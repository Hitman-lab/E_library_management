package com.filter_pages;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import sun.security.provider.certpath.ResponderId;

public class AdminLoginVerify implements Filter {

	public AdminLoginVerify() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

//		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String username = request.getParameter("username");
		String pass = request.getParameter("password");

		if (pass.equals("admin@123") && username.equals("admin@outlook.com")) {
			chain.doFilter(req, res);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("adminLoginError.jsp");
			rd.include(req, res);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
