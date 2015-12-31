<%@page import="com.model.Empleado"%>
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

<title>List Empleados</title>
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
			<th>Foto</th>
			<th>Sector</th>
			<th>Categoria</th>
			<th>Fecha de Ingreso</th>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			List<Empleado> empleados = (List<Empleado>) session.getAttribute("empleados");
			int pos = 0;
			for (Empleado empleado : empleados) {
		%>
		<tr>
			<td><%=empleado.getNombre()%></td>
			<td><%=empleado.getApellido()%></td>
			<td><%=empleado.getTipoDoc()%></td>
			<td><%=empleado.getNumDoc()%></td>
			<td><%=empleado.getTelFijo()%></td>
			<td><%=empleado.getTelCel()%></td>
			<td><%=empleado.getDireccion()%></td>
			<td><%=empleado.getCiudad()%></td>
			<td><%=empleado.getProvincia()%></td>
			<td><%=empleado.getNacionalidad()%></td>
			<td><%=empleado.getE_mail()%></td>
			<td><%=empleado.getFoto()%></td>
			<td><%=empleado.getSector()%></td>
			<td><%=empleado.getCategoria()%></td>
			<td><%=empleado.getFechaIngreso()%></td>
			<td><a href="EmpleadoDeleteServlet?empleadoId=<%=empleado.getEmpleadoId()%>">Eliminar</a></td>
			<td><a href="empleadoUpdate.jsp?pos=<%=pos%>">Modificar</a></td>
		</tr>
		<%
			pos++;
		}
		%>
	</table>
<button id="CancelEmpleado">volver</button>

	<!-- jQuery -->
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>