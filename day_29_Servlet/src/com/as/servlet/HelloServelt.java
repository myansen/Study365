package com.as.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServelt implements Servlet {
	
	
	public HelloServelt() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("HelloServlet generated constructor");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		//getInitParameter获取指定参数名的初始化参数（值）
		System.out.println("init");
		String user=servletConfig.getInitParameter("user");
		System.out.println(user);
		
		//getInitParameterNames获取参数名组成的Enumeration对象
		Enumeration<String> names=servletConfig.getInitParameterNames();
		while(names.hasMoreElements()){
			String name =names.nextElement();
			String value=servletConfig.getInitParameter(name);
			System.out.println("name:"+name+" value:"+value);
		}
		
		String servletName =servletConfig.getServletName();
		
		System.out.println("servletName:"+ servletName);
		
		ServletContext servletContext=servletConfig.getServletContext();
		System.out.println("getServletContext"+servletContext);
		
		String driver =servletContext.getInitParameter("driver");
		System.out.println("driver:"+driver);
		
		Enumeration<String> names2=servletContext.getInitParameterNames();
		while(names2.hasMoreElements()){
			String name =names2.nextElement();
			System.out.println("name:"+name);
			String value=servletContext.getInitParameter(name);
			System.out.println("name:"+name+" value:"+value);
		}
		
		String realPath= servletContext.getRealPath("/index.html");
		
		System.out.println("realPaht(/index.jsp):"+realPath);
		
		String contextPath= servletContext.getContextPath();
		
		System.out.println("contextPath:"+contextPath);

		try {
			ClassLoader classLoader=getClass().getClassLoader();
			InputStream is= classLoader.getResourceAsStream("jdbc.properties");
			System.out.println("is1."+is);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			InputStream is2=servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			System.out.println("is2."+is2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		System.out.println("service");
		System.out.println("arg0:"+arg0);
		
		System.out.println("arg1:"+arg1);
	}

}
