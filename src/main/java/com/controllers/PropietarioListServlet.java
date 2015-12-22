package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.model.Cliente;
import com.service.ClienteService;
/**
 * Servlet implementation class PropietarioListServlet
 */
public class PropietarioListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropietarioListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Connection con = (Connection) request.getSession().getAttribute("h2.connection");
			
			List<Cliente> clientes = ClienteService.getAllClientes(con);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("clientes", clientes);

			response.sendRedirect("clienteList.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
