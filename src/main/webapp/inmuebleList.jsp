<%@page import="com.model.Inmueble"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>List Inmuebles</title>
</head>
<body>
	<%@page isErrorPage="false" errorPage="Error.jsp"%>

	<table class="table table-bordered">
		<tr>
			<th>descripcion</th>
			<th>tipoDeInmueble</th>
			<th>tipoDeOperacion</th>
			<th>tipoDeEstado</th>
			<th>estado</th>
			<th>Direccion</th>
			<th>piso</th>
			<th>dpto</th>
			<th>Ciudad</th>
			<th>Provincia</th>
			<th>numHabitaciones
			<th>banios</th>
			<th>m2</th>
			<th>alquiler</th>
			 <th>venta</th>
			<th>tipoSuelo</th>
			<th> garage</th>
			<th>ascensor</th>
			<th>amueblado</th>
			<th>comision</th>
		</tr>
		
		<%
			@SuppressWarnings("unchecked")
			List<Inmueble> inmbles = (List<Inmueble>) session.getAttribute("inmuebles");
			int pos = 0;
			for (Inmueble inmbl : inmbles) {
		%>
		<tr>
		<td><%=inmbl.getDescripcion()%></td>
		<td><%=inmbl.getTipoDeInmueble()%></td>
		<td><%=inmbl.getTipoDeOperacion()%></td>
		<td><%=inmbl.getTipoDeEstado()%></td>
		<td><%=inmbl.getEstado()%></td>
		<td><%=inmbl.getDireccion()%></td>
		<td><%=inmbl.getPiso()%></td>
		<td><%=inmbl.getDpto()%></td>
		<td><%=inmbl.getCiudad()%></td>
		<td><%=inmbl.getProvincia()%></td>
		<td><%=inmbl.getNumHabitaciones()%></td>
		<td><%=inmbl.getBanios()%></td>
		<td><%=inmbl.getM2()%></td>
		<td><%=inmbl.getAlquiler()%></td>
		<td><%=inmbl.getVenta()%></td>
		<td><%=inmbl.getTipoSuelo()%></td>
		<td><%=inmbl.isGarage()%></td>
		<td><%=inmbl.isAscensor()%></td>
		<td><%=inmbl.isAmueblado()%></td>
		<td><%=inmbl.getComision()%></td>
			<td><a href="DeleteInmuebleServlet?id=<%=inmbl.getInmuebleId()%>">Eliminar</a></td>
			<td><a href="inmuebleUpdate.jsp?pos=<%=pos%>">Modificar</a></td>
		</tr>
		<%
		pos++;
			}
		%>
	</table>
	
		<button  class="volverButton" id="CancelInmueble">volver</button>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>

</body>
</html>