<%@page import="com.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Clientes</title>
</head>
<body>

<table>
		<thead>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Tipo Doc</td>
			<td>Num Doc</td>
			<td>Tel Fijo</td>
			<td>Tel Cel</td>
			<td>Direccion</td>
			<td>Ciudad</td>
			<td>Provincia</td>
			<td>Nacionalidad</td>
			<td>E-mail</td>
		</thead>
		<%
			List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
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