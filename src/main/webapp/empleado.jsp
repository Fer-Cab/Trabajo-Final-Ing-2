<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet"  href="css/styles.css"/>

<title>Empleado page</title>
</head>

<%String m; %>
	<%if ((m = request.getParameter("msj")) != null){ %>
	
<body onload="show ('<%=m%>')">
<% } %>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

	<div class="container">
		<h2>Opciones Empleado</h2>
		<ul>
			<li><a href="empleadoCreate.html">crear Empleado</a></li>
			<li><a href="empleadoUpdate.html">modificar Empleado</a></li>
			<li><a href="empleadoDelete.html">borrar Empleado</a></li>
			<li><a href="EmpleadoListServlet">Listar Empleado</a></li>
			<li><a href="empleadoFind.html">buscar Empleado por Tipo And Num Doc</a></li>
		</ul>
		<button id="btnCancel">volver</button>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
      <script type="text/javascript" src="js/ej.js"></script>
	  
	</div>

</body>
</html>