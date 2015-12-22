package com.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Propietario;
import com.service.PropietarioService;

/**
 * Servlet implementation class PropietarioFindServlet
 */
public class PropietarioFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropietarioFindServlet() {
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
		try {
			 Connection con = (Connection) request.getSession().getAttribute("h2.connection");
			 
			String tipoDoc = request.getParameter("tipoDoc");
			int numDoc = Integer.parseInt(request.getParameter("numDoc"));

			List<Propietario> propietarios = new ArrayList<>();
			System.out.println(PropietarioService.findByTipoDocAndNumDoc(tipoDoc, numDoc,con));
			propietarios.add(PropietarioService.findByTipoDocAndNumDoc(tipoDoc, numDoc,con));
			HttpSession sesion = request.getSession();
			sesion.setAttribute("propietarios", propietarios);

			response.sendRedirect("propietarioList.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}
	}

}
