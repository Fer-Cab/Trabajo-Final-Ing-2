<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet"  href="css/styles.css"/>
<title>inmueble page</title>
</head>

<%String m; %>
	<%if ((m = request.getParameter("msj")) != null){ %>
	
<body onload="show ('<%=m%>')">
<% } %>
<%@page isErrorPage="false" errorPage="Error.jsp"%>
 

	<div class="container">
		<h2>Opciones Inmueble</h2>
		<ul>
			<li><a href="inmuebleCreate.html">crear inmueble</a></li>
			<li><a href="inmuebleUpdate.html">modificar inmueble</a></li>
			<li><a href="inmuebleDelete.html">borrar inmueble</a></li>
			<li><a href="ListInmuebleServlet">Listar inmuebles</a></li>
			<li><a href="inmuebleFind.html">buscar inmueble por Direccion Piso And Dpto </a></li>
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