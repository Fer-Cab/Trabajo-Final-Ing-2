package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Empleado;
import com.service.EmpleadoService;
/**
 * Servlet implementation class EmpleadoCreateServlet
 */
public class EmpleadoCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoCreateServlet() {
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
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String tipoDoc = request.getParameter("tipoDoc");
		int numDoc = Integer.parseInt(request.getParameter("numDoc"));
		int telFijo = Integer.parseInt(request.getParameter("telFijo"));
		int telCel = Integer.parseInt(request.getParameter("telCel"));
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String provincia = request.getParameter("provincia");
		String nacionalidad = request.getParameter("nacionalidad");
		String e_mail = request.getParameter("e_mail");
		String foto = request.getParameter("foto");
		String sector = request.getParameter("sector");
		String categoria = request.getParameter("categoria");
		String fechaIngreso = request.getParameter("fechaIngreso");
		
		Empleado empleado = new Empleado(nombre, apellido, tipoDoc, numDoc, telFijo, telCel, direccion, ciudad, provincia, nacionalidad, e_mail, foto, sector, categoria, fechaIngreso);

		try {
			 Connection con = (Connection) request.getSession().getAttribute("h2.connection");
			 
			EmpleadoService.createEmpleado(empleado,con);

			response.sendRedirect("home.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}

	
	}

}
