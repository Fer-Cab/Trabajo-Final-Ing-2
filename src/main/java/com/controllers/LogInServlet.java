package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		/*
		 * if(accountService.userExist(account))
			return "user access granted";
					
		else
			throw new UserNotFoundWrongPassException(account.userName);
		 */
		
		/*
		 * 	String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User(username, password);
		User temp = null;
		try {
			temp = new AccionesUser().getOne(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (temp!=null) {
			response.sendRedirect("index.html");
			HttpSession session = request.getSession();
			session.setAttribute("username", temp.getUsername());
		} 
		else {
			response.sendRedirect("Login.jsp?e=1");
		}
		 */
	}

}
