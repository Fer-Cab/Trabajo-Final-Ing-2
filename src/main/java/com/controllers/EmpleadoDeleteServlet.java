package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpleadoService;

/**
 * Servlet implementation class EmpleadoDeleteServlet
 */
public class EmpleadoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoDeleteServlet() {
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
		
		Long empleadoId = Long.parseLong(request.getParameter("empleadoId"));

		try {
			Connection con = (Connection) request.getSession().getAttribute("h2.connection");

			EmpleadoService.deleteEmpleado(empleadoId, con);

			response.sendRedirect("home.html");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}
		
	}

}
