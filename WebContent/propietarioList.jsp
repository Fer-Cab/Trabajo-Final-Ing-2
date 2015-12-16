<%@page import="com.model.Cliente"%>
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

<title>List Clientes</title>
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
		</tr>
		<%
			List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
			int pos = 0;
			for (Cliente client : clientes) {
		%>
		<tr>
			<td><%=client.getNombre()%></td>
			<td><%=client.getApellido()%></td>
			<td><%=client.getTipoDoc()%></td>
			<td><%=client.getNumDoc()%></td>
			<td><%=client.getTelFijo()%></td>
			<td><%=client.getTelCel()%></td>
			<td><%=client.getDireccion()%></td>
			<td><%=client.getCiudad()%></td>
			<td><%=client.getProvincia()%></td>
			<td><%=client.getNacionalidad()%></td>
			<td><%=client.getE_mail()%></td>
			<td><a href="DeleteClienteServlet?id=<%=client.getClienteId()%>">Eliminar</a></td>
			<td><a href="ModificarClienteServlet?id=<%=client.getClienteId()%>">Modificar</a></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>