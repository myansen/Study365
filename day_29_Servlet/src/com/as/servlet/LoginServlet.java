package com.as.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse servletResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ÇëÇóÀ´ÁË");
		String user= request.getParameter("user");
		String password= request.getParameter("password");
		System.out.println("user:"+user+" password:"+password);
		
		String interesting =request.getParameter("interesting");
		System.out.println("interestin:"+interesting);
		
		String[] interestings = request.getParameterValues("interesting");
		for(String interest: interestings){
			System.out.println("-->"+interest);
		}
	
		Enumeration<String> names =request.getParameterNames();
		while(names.hasMoreElements()){
			String name =names.nextElement();
			String val =request.getParameter(name);
			
			System.out.println("name:"+name +" value:"+val);
		}

	
		Map<String,String[]> map=request.getParameterMap();
		for(Map.Entry<String, String[]> entry: map.entrySet()){
			System.out.println("**"+entry.getKey()+":"+Arrays.asList(entry.getValue()));
		}
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String requestURI= httpServletRequest.getRequestURI();
		
		System.out.println("requestURI£º"+requestURI);
		
		String reqestURL =httpServletRequest.getRequestURL().toString();
		
		System.out.println("requestURL:"+reqestURL);
		
		String queryString =httpServletRequest.getQueryString();
		System.out.println("queryString:"+queryString);
	}

}
