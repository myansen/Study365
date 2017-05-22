package com.as.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends MyGenericServlet {

	//对当前Servlet进行初始化：涵盖init方法
	//@Override
//	public void init() throws ServletException {
//		System.out.println("初始化...");
//	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//调用了父类的init方法，就不会出现了空指针异常.
		super.init(arg0);
	}

	
	
	//private ServletConfig servletConfig;
	
	
	

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 1.获取请求参数：username,password
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2.获取当前WEB应用的初始化参数user,password
		/*ServletContext servletContext =servletConfig.getServletContext();
		String initUser =servletContext.getInitParameter("user");
		String initPassword=servletContext.getInitParameter("password");
		*/
		String initUser =getServletContext().getInitParameter("user");
		String initPassword=getServletContext().getInitParameter("password");
		
		Enumeration<String> names =getServletContext().getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name:"+name);
			String val =getServletContext().getInitParameter(name);
			System.out.println("val:"+val);
		}
		
		// 3.比对
		// 4.打印响应从字符串
		PrintWriter out=response.getWriter();
		if(initUser.equals(username)&& initPassword.equals(password) ){
			System.out.println("Hello:"+username);
			out.print("Hello:"+username);
		}else{
			System.out.println("Sorry:"+username);
			out.print("Sorry:"+username);
		}
	}
}
