<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet"  href="css/styles.css"/>
<meta charset="UTF-8"/>
<title>Cliente page</title>
</head>
<%String m; %>
	<%if ((m = request.getParameter("msj")) != null){ %>
	
<body onload="show ('<%=m%>')">
<% } %>
<%@page isErrorPage="false" errorPage="Error.jsp"%>	

		<div class="container">
			<h2>Opciones Cliente</h2>
			<ul>
				<li><a href="clienteCreate.html">crear cliente</a></li>
				<li><a href="clienteUpdate.html">modificar cliente</a></li>
				<li><a href="clienteDelete.html">borrar cliente</a></li>
				<li><a href="ClienteListServlet">Listar clientes</a></li>
				<li><a href="clienteFind.html">buscar cliente por Tipo And Num Doc</a></li>
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