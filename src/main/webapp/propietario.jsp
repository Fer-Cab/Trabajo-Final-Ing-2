<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet"  href="css/styles.css"/>
<title>Propietario page</title>


</head>
<%String m; %>
	<%if ((m = request.getParameter("msj")) != null){ %>
	
<body onload="show ('<%=m%>')">
<% } %>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

 
	<div class="container">
		<h2>Opciones Propietario</h2>
		<ul>
			<li><a href="propietarioCreate.html">crear Propietario</a></li>
			<li><a href="propietarioUpdate.html">modificar Propietario</a></li>
			<li><a href="propietarioDelete.html">borrar Propietario</a></li>
			<li><a href="ListPropietarioServlet">Listar Propietario</a></li>
			<li><a href="propietarioFind.html">buscar Propietario por Tipo And Num Doc</a></li>
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