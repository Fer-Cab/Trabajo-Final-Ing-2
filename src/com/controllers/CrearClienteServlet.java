package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conexion.Conexion;
import com.model.Cliente;
import com.service.ClienteService;

/**
 * Servlet implementation class CrearClienteServlet
 */
@WebServlet("/CrearClienteServlet")
public class CrearClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CrearClienteServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
	/*	Conexion con = new Conexion();
		
		try {
			con.initDb();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String tipoDoc = request.getParameter("apellido");
		int numDoc = Integer.parseInt(request.getParameter("numDoc"));
		int telFijo = Integer.parseInt(request.getParameter("telFijo"));
		int telCel = Integer.parseInt(request.getParameter("telCel"));
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String provincia = request.getParameter("provincia");
		String nacionalidad = request.getParameter("nacionalidad");
		String e_mail = request.getParameter("e_mail");

		Cliente client = new Cliente(nombre, apellido, tipoDoc, numDoc, telFijo, telCel, direccion, ciudad, provincia,
				nacionalidad, e_mail);

		try {
			ClienteService.createCliente(client);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("home.html");

	}

}
