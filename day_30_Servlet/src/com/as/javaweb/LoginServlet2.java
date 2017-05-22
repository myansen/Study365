package com.as.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取请求方法是GET还是POST
		String method = request.getMethod();

		System.out.println(method);

		// 1.获取请求参数：username,password
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2.获取当前WEB应用的初始化参数user,password
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");

		Enumeration<String> names = getServletContext().getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name:" + name);
			String val = getServletContext().getInitParameter(name);
			System.out.println("val:" + val);
		}

		// 3.比对
		// 4.打印响应从字符串
		PrintWriter out = response.getWriter();
		if (initUser.equals(username) && initPassword.equals(password)) {
			System.out.println("Hello:" + username);
			out.print("Hello:" + username);
		} else {
			System.out.println("Sorry:" + username);
			out.print("Sorry:" + username);
		}

	}
}
