<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  href="css/styles.css"/>



<title>Account page</title>

</head>
<%String m; %>
	<%if ((m = request.getParameter("msj")) != null){ %>
	
<body onload="show ('<%=m%>')">
<% } %>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<%  String msj = "you do not have permission to do that";
    if (!(session.getAttribute("permiso").toString().equalsIgnoreCase("admin") ||
		session.getAttribute("permiso").toString().equalsIgnoreCase("gerente"))) 
    	((HttpServletResponse)response).sendRedirect("home.jsp?msj="+msj);          %>

	<div class="container">
			<h2>Opciones Account</h2>
			<ul>
				<li><a href="accountCreate.html">crear cuenta</a></li>
				<li><a href="accountUpdate.html">modificar cuenta</a></li>
				<li><a href="accountDelete.html">borrar cuenta</a></li>
			</ul>
			 

<button id="btnCancel">volver</button>
		</div>
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
      
</body>
</html>