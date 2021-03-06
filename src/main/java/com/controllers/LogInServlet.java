package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exception.UserNotFoundWrongPassException;
import com.service.AccountService;

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

		String name = request.getParameter("userName");
		String pass = request.getParameter("password");
	
		try {
			 Connection con = (Connection) request.getSession().getAttribute("h2.connection");
			 
			if(AccountService.canLog(name, pass, con)){
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("permiso",AccountService.findByUserName(name, con).getPermisos());
				
				response.sendRedirect("home.html");
			}
				else throw new UserNotFoundWrongPassException();
		} catch (Exception e) {
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}
	}

}
