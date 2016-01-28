<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet"  href="css/styles.css"/>
<title>Contratos page</title>


</head>
<%String m; %>
	<%if ((m = request.getParameter("msj")) != null){ %>
	
<body onload="show ('<%=m%>')">
<% } %>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

 
	<div class="container">
		<h2>Contratos</h2>
        
        <h3>Contrato de Alquiler</h3>
		<ul>
			<li><a href="contratoAlquilerCreate.jsp">crear Contrato de Alquiler</a></li>
			<li><a href="contratoAlquilerUpdate.jsp">modificar Contrato de Alquiler</a></li>
			<li><a href="contratoAlquilerDelete.jsp">borrar Contrato de Alquiler</a></li>
			<li><a href="contratoAlquilerListServlet">Listar Contrato de Alquiler</a></li>
			<li><a href="contratoAlquilerFind.jsp">buscar Contrato de Alquiler por ...</a></li>
		</ul>
        
        <h3>Contrato de Venta</h3>
        <ul>
            <li><a href="contratoVentaCreate.jsp">crear Contrato de Venta</a></li>
            <li><a href="contratoVentaUpdate.jsp">modificar Contrato de Venta</a></li>
            <li><a href="contratoVentaDelete.jsp">borrar Contrato de Venta</a></li>
            <li><a href="contratoVentaListServlet">Listar Contrato de Venta</a></li>
            <li><a href="contratoVentaFind.jsp">buscar Contrato de Venta por ...</a></li>
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