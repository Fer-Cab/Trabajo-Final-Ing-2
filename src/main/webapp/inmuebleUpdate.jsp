<%@page import="com.model.Inmueble"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Inmueble update page</title>
</head>
<body>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<h2>Modificar Inmueble</h2>

<form id="formUpdateInmueble" action="InmuebleUpdateServlet" method="post">

<%
		@SuppressWarnings("unchecked")
		List<Inmueble> inmuebles = (List<Inmueble>) session.getAttribute("inmuebles");
			int pos = Integer.parseInt(request.getParameter("pos"));		%>
			
		
	 	<label for="descripcion">descripcion</label>
			<input type="text" name="descripcion" id="descripcion" value="<%=inmuebles.get(pos).getDescripcion()%>"/><br/>
		<label for="tipoDeInmueble">tipoDeInmueble</label>
			<input type="text" name="tipoDeInmueble" id="tipoDeInmueble" value="<%=inmuebles.get(pos).getTipoDeInmueble()%>"/><br/>
		<label for="tipoDeOperacion">tipoDeOperacion</label>
			<input type="text" name="tipoDeOperacion" id="tipoDeOperacion" value="<%=inmuebles.get(pos).getTipoDeOperacion()%>"/><br/>
		<label for="tipoDeEstado">tipoDeEstado</label>
			<input type="text" name="tipoDeEstado" id="tipoDeEstado" value="<%=inmuebles.get(pos).getTipoDeEstado()%>"/><br/>
		<label for="estado">estado</label>
			<input type="text" name="estado" id="estado" value="<%=inmuebles.get(pos).getEstado()%>"/><br/>
		<label for="direccion">direccion</label>
			<input type="text" name="direccion" id="direccion" value="<%=inmuebles.get(pos).getDireccion()%>"/><br/>
		<label for="piso">piso</label>
			<input type="text" name="piso" id="piso" value="<%=inmuebles.get(pos).getPiso()%>"/><br/>
		<label for="dpto">dpto</label>
			<input type="text" name="dpto" id="dpto" value="<%=inmuebles.get(pos).getDpto()%>"/><br/>
		<label for="ciudad">ciudad</label>
			<input type="text" name="ciudad" id="ciudad" value="<%=inmuebles.get(pos).getCiudad()%>"/><br/>
		<label for="provincia">provincia</label>
			<input type="text" name="provincia" id="provincia" value="<%=inmuebles.get(pos).getProvincia()%>"/><br/>
		<label for="numHabitaciones">numHabitaciones</label> 
	 		<input type="text" name="numHabitaciones" id="numHabitaciones" value="<%=inmuebles.get(pos).getNumHabitaciones()%>"/><p >int</p><br/> 
		<label for="banios">banios</label> 
			<input type="text" name="banios" id="banios" value="<%=inmuebles.get(pos).getBanios()%>"/>int<br/> 
		<label for="m2">metros cuadrados</label> 
			<input type="text" name="m2" id="m2" value="<%=inmuebles.get(pos).getM2()%>"/>int<br/> 
		<label for="alquiler">alquiler</label> 
			<input type="text" name="alquiler" id="alquiler" value="<%=inmuebles.get(pos).getAlquiler()%>"/>double<br/> 
		<label for="venta">venta</label> 
			<input type="text" name="venta" id="venta" value="<%=inmuebles.get(pos).getVenta()%>"/>double<br/> 
		<label for="tipoSuelo">tipoSuelo</label> 
			<input type="text" name="tipoSuelo" id="tipoSuelo" value="<%=inmuebles.get(pos).getTipoSuelo()%>"/><br/> 
		<label for="garage">garage</label> 
			<input type="text" name="garage" id="garage" value="<%=inmuebles.get(pos).isGarage()%>"/>boolean<br/> 
		<label for="ascensor">ascensor</label>
			<input type="text" name="ascensor" id="ascensor" value="<%=inmuebles.get(pos).isAscensor()%>"/>boolean<br/> 
		<label for="amueblado">amueblado</label> 
			<input type="text" name="amueblado" id="amueblado" value="<%=inmuebles.get(pos).isAmueblado()%>"/>boolean<br/> 
		<label for="comision">comision</label>
			<input type="text" name="comision" id="comision" value="<%=inmuebles.get(pos).getComision()%>"/>double<br/>
	
		<fieldset>
			<legend>Aceptar:</legend>
				<input type="submit" value="crear"/>	
				<input type="reset" value="cancel"/>
		</fieldset>
	
	</form>
		<button id="CancelInmueble">volver</button>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
	  
	</body>
</html>