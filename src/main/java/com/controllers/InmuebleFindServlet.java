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

import com.model.Inmueble;
import com.service.InmuebleService;

/**
 * Servlet implementation class InmuebleFindServlet
 */
public class InmuebleFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InmuebleFindServlet() {
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
			 
			 String direccion = request.getParameter("direccion");
			 String piso  = request.getParameter("piso");
			 String dpto  = request.getParameter("dpto");

			
			List<Inmueble> inmuebles = new ArrayList<>();
			System.out.println(InmuebleService.findByDireccionAndPisoAndDpto(direccion, piso, dpto, con));
			inmuebles.add(InmuebleService.findByDireccionAndPisoAndDpto(direccion, piso, dpto, con));
			HttpSession sesion = request.getSession();
			sesion.setAttribute("inmuebles", inmuebles);

			response.sendRedirect("inmuebleList.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}
	}

}
