<%@page import="com.model.Empleado"%>
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
<title>Empleado update page</title>
</head>
<body>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<h2>Modificar Cliente</h2>

<form id="formUpdateClient" action="ModificarClienteServlet" method="post">

<%			
	@SuppressWarnings("unchecked")
	List<Empleado> empleados = (List<Empleado>) session.getAttribute("empleados");
			int pos = Integer.parseInt(request.getParameter("pos"));		%>
			
		<label for="nombre">nombre</label> 
			<input type="text" name="nombre"id="nombre" value="<%=empleados.get(pos).getNombre()%>"/><br/>
	 	<label for="apellido">apellido</label> 
	 		<input type="text" name="apellido" id="apellido" value="<%=empleados.get(pos).getApellido()%>"/><br/> 
		<label for="tipoDoc">tipoDoc</label> 
			<input type="text" name="tipoDoc" id="tipoDoc" value="<%=empleados.get(pos).getTipoDoc()%>"/><br/> 
		<label for="numDoc">numDoc</label> 
			<input type="text" name="numDoc" id="numDoc" value="<%=empleados.get(pos).getNumDoc()%>"/>int<br/> 
		<label for="telFijo">telFijo</label> 
			<input type="text" name="telFijo" id="telFijo" value="<%=empleados.get(pos).getTelFijo()%>"/>int<br/> 
		<label for="telCel">telCel</label> 
			<input type="text" name="telCel" id="telCel" value="<%=empleados.get(pos).getTelCel()%>"/>int<br/> 
		<label for="direccion">direccion</label> 
			<input type="text" name="direccion" id="direccion" value="<%=empleados.get(pos).getDireccion()%>"/><br/> 
		<label for="ciudad">ciudad</label> 
			<input type="text" name="ciudad" id="ciudad" value="<%=empleados.get(pos).getCiudad()%>"/><br/> 
		<label for="provincia">provincia</label>
			<input type="text" name="provincia" id="provincia" value="<%=empleados.get(pos).getProvincia()%>"/><br/> 
		<label for="nacionalidad">nacionalidad</label> 
			<input type="text" name="nacionalidad" id="nacionalidad" value="<%=empleados.get(pos).getNacionalidad()%>"/><br/> 
		<label for="e_mail">E-mail</label>
			<input type="text" name="e_mail" id="e_mail" value="<%=empleados.get(pos).getE_mail()%>"/><br/>
		<label for="foto">foto</label>
			<input type="text" name="foto" id="foto" value="<%=empleados.get(pos).getFoto()%>"/><br/>
		<label for="sector">sector</label> 
			<input type="text" name="sector" id="sector" value="<%=empleados.get(pos).getSector()%>"/><br/>
		<label for="categoria">categoria</label>
			<input type="text" name="categoria" id="categoria" value="<%=empleados.get(pos).getCategoria()%>"/><br/>
		<label for="fechaIngreso">fechaIngreso</label>
			<input type="text" name="fechaIngreso" id="fechaIngreso" value="<%=empleados.get(pos).getFechaIngreso()%>"/><br/>
	
		<fieldset>
			<legend>Aceptar:</legend>
				<input type="submit" value="crear"/>	
				<input type="reset" value="cancel"/>
		</fieldset>
	
	</form>
		<button id="btnCancel">volver</button>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
	  
	</body>
</html>