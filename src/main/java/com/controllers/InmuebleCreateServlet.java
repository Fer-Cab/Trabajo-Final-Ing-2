package com.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Inmueble;
import com.service.InmuebleService;

/**
 * Servlet implementation class InmuebleCreateServlet
 */
public class InmuebleCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InmuebleCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String descripcion = request.getParameter("descripcion");
		String tipoDeInmueble = request.getParameter("tipoDeInmueble");
		String tipoDeOperacion = request.getParameter("tipoDeOperacion");
		String estado = request.getParameter("estado");
		String direccion = request.getParameter("direccion");
		String piso = request.getParameter("piso");
		String dpto = request.getParameter("dpto");
		String ciudad = request.getParameter("ciudad");
		String provincia = request.getParameter("provincia");
		int numHabitaciones = Integer.parseInt(request.getParameter("numHabitaciones"));
		int banios = Integer.parseInt(request.getParameter("banios"));
		int m2 = Integer.parseInt(request.getParameter("m2"));
		double alquiler = Double.parseDouble(request.getParameter("alquiler"));
		double venta = Double.parseDouble(request.getParameter("venta"));
		String tipoSuelo = request.getParameter("tipoSuelo");
		boolean garage = Boolean.getBoolean(request.getParameter("garage"));
		boolean ascensor = Boolean.getBoolean(request.getParameter("ascensor"));
		boolean amueblado = Boolean.getBoolean(request.getParameter("amueblado"));
		double comision = Double.parseDouble(request.getParameter("comision"));
		String tipoDoc = request.getParameter("tipoDoc");
		int numDoc = Integer.parseInt(request.getParameter("numDoc"));

		
		Inmueble inmbl = new Inmueble(descripcion, tipoDeInmueble, tipoDeOperacion,  estado, direccion,
				piso, dpto, ciudad, provincia, numHabitaciones, banios, m2, alquiler, venta, tipoSuelo, garage,
				ascensor, amueblado, comision,tipoDoc,  numDoc);

		try {
			Connection con = (Connection) request.getSession().getAttribute("h2.connection");

			InmuebleService.createInmueble(inmbl, con);

			String msj = "inmueble creado";
			response.sendRedirect("inmueble.jsp?msj="+msj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			response.sendRedirect("Error.jsp?error=" + e.toString());
		}

	}

}
