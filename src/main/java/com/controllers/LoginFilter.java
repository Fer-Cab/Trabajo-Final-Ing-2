package com.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

	protected FilterConfig filterConfig;
	
	 public void init(FilterConfig config) throws ServletException {
	       filterConfig = config;
	       filterConfig.getServletContext().log(":: PostLoginFilter - init");
	    }
	 
	
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
		 
		 filterConfig.getServletContext().log(":: PostLoginFilter - doFilter");
		 
			HttpSession s = ((HttpServletRequest)request).getSession();
			if (s.getAttribute("username")!=null){
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse)response).sendRedirect("Login.jsp");
			}
		}		 
	 
	 /*
	  * 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession s = ((HttpServletRequest)request).getSession();
		if (s.getAttribute("username")!=null){
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("Login.jsp");
		}


	}
	  */
	 
    public void destroy() {
       filterConfig.getServletContext()
          .log(":: PostLoginFilter - destroy");
       filterConfig = null;
    }


}
