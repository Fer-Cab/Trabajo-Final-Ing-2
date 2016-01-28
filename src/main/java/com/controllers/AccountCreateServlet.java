package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Account;
import com.service.AccountService;

/**
 * Servlet implementation class AccountCreateServlet
 */
public class AccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCreateServlet() {
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
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String permisos = request.getParameter("permisos");
		String tipoDoc = request.getParameter("tipoDoc");
		int numDoc = Integer.parseInt(request.getParameter("numDoc"));
		String msj = "usuario creado";
		
		Account account = new Account(name, password, permisos, tipoDoc, numDoc);
		
		try {
			 Connection con = (Connection) request.getSession().getAttribute("h2.connection");
			 
			AccountService.createAccount(account,con);

			response.sendRedirect("account.jsp?msj="+msj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
			System.out.println(e);
		}
	}

}
