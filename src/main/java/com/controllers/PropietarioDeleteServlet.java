package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.PropietarioService;

/**
 * Servlet implementation class PropietarioDeleteServlet
 */
public class PropietarioDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropietarioDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long propietarioId = Long.parseLong(request.getParameter("propietarioId"));

		try {
			Connection con = (Connection) request.getSession().getAttribute("h2.connection");

			PropietarioService.deletePropietario(propietarioId, con);

			response.sendRedirect("home.html");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}
		
	}

}
