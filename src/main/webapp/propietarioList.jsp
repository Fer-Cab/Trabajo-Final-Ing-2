<%@page import="com.model.Propietario"%>
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

<title>List Propietarios</title>
</head>
<body>
	<%@page isErrorPage="false" errorPage="Error.jsp"%>

	<table class="table table-bordered">
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Tipo Doc</th>
			<th>Num Doc</th>
			<th>Tel Fijo</th>
			<th>Tel Cel</th>
			<th>Direccion</th>
			<th>Ciudad</th>
			<th>Provincia</th>
			<th>Nacionalidad</th>
			<th>E-mail</th>
			<th>Numero de Cuenta</th>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			List<Propietario> propietarios = (List<Propietario>) session.getAttribute("propietarios");
			int pos = 0;
			for (Propietario propietario : propietarios) {
		%>
		<tr>
			<td><%=propietario.getNombre()%></td>
			<td><%=propietario.getApellido()%></td>
			<td><%=propietario.getTipoDoc()%></td>
			<td><%=propietario.getNumDoc()%></td>
			<td><%=propietario.getTelFijo()%></td>
			<td><%=propietario.getTelCel()%></td>
			<td><%=propietario.getDireccion()%></td>
			<td><%=propietario.getCiudad()%></td>
			<td><%=propietario.getProvincia()%></td>
			<td><%=propietario.getNacionalidad()%></td>
			<td><%=propietario.getE_mail()%></td>
			<td><%=propietario.getNumCuenta()%></td>
			<td><a href="PropietarioDeleteServlet?propietarioId=<%=propietario.getPropietarioId()%>">Eliminar</a></td>
			<td><a href="PropietarioUpdate.jsp?pos=<%=pos%>">Modificar</a></td>
		</tr>
		<%
				pos++;
			}
		%>
	</table>
<button  class="volverButton" id="btnCancel">volver</button>

	<!-- jQuery -->
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>