package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Cliente;
import com.service.ClienteService;

/**
 * Servlet implementation class ClienteUpdateServlet
 */
public class ClienteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteUpdateServlet() {
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

		Cliente client = new Cliente(nombre, apellido, tipoDoc, numDoc,
									telFijo, telCel, direccion, ciudad, provincia, 
									nacionalidad, e_mail);

		try {
			 Connection con = (Connection) request.getSession().getAttribute("h2.connection");
			 
			ClienteService.updateCliente(client, con);

			String msj = "cliente modificado";
			response.sendRedirect("cliente.jsp?msj="+msj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}

		
	}

}
