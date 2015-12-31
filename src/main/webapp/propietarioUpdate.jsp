<%@page import="com.model.Propietario"%>
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
<title>Propietario update page</title>
</head>
<body>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<h2>Modificar Propietario</h2>

<form id="formUpdatePropietario" action="PropietarioUpdateServlet" method="post">

<%
		@SuppressWarnings("unchecked")
		List<Propietario> propietarios = (List<Propietario>) session.getAttribute("propietarios");
			int pos = Integer.parseInt(request.getParameter("pos"));		%>
			
		<label for="nombre">nombre</label> 
			<input type="text" name="nombre"id="nombre" value="<%=propietarios.get(pos).getNombre()%>"/><br/>
	 	<label for="apellido">apellido</label> 
	 		<input type="text" name="apellido" id="apellido" value="<%=propietarios.get(pos).getApellido()%>"/><br/> 
		<label for="tipoDoc">tipoDoc</label> 
			<input type="text" name="tipoDoc" id="tipoDoc" value="<%=propietarios.get(pos).getTipoDoc()%>"/><br/> 
		<label for="numDoc">numDoc</label> 
			<input type="text" name="numDoc" id="numDoc" value="<%=propietarios.get(pos).getNumDoc()%>"/>int<br/> 
		<label for="telFijo">telFijo</label> 
			<input type="text" name="telFijo" id="telFijo" value="<%=propietarios.get(pos).getTelFijo()%>"/>int<br/> 
		<label for="telCel">telCel</label> 
			<input type="text" name="telCel" id="telCel" value="<%=propietarios.get(pos).getTelCel()%>"/>int<br/> 
		<label for="direccion">direccion</label> 
			<input type="text" name="direccion" id="direccion" value="<%=propietarios.get(pos).getDireccion()%>"/><br/> 
		<label for="ciudad">ciudad</label> 
			<input type="text" name="ciudad" id="ciudad" value="<%=propietarios.get(pos).getCiudad()%>"/><br/> 
		<label for="provincia">provincia</label>
			<input type="text" name="provincia" id="provincia" value="<%=propietarios.get(pos).getProvincia()%>"/><br/> 
		<label for="nacionalidad">nacionalidad</label> 
			<input type="text" name="nacionalidad" id="nacionalidad" value="<%=propietarios.get(pos).getNacionalidad()%>"/><br/> 
		<label for="e_mail">E-mail</label>
			<input type="text" name="e_mail" id="e_mail" value="<%=propietarios.get(pos).getE_mail()%>"/><br/>
		<label for="numCuenta">numero de Cuenta</label>
			<input type="text" name="numCuenta" id="numCuenta" value="<%=propietarios.get(pos).getNumCuenta()%>"/><br/>
	
		<fieldset>
			<legend>Aceptar:</legend>
				<input type="submit" value="crear"/>	
				<input type="reset" value="cancel"/>
		</fieldset>
	
	</form>
		<button id="CancelProp">volver</button>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
	  
	</body>
</html>