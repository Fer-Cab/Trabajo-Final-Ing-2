<%@page import="com.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Cliente page</title>
</head>
<body>

<%@page isErrorPage="false" errorPage="Error.jsp"%>

<div id="cliente">

<h2>Modificar Cliente</h2>
<form id="formUpdateClient" action="ClienteUpdateServlet" method="post">

	<%
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
			int pos = Integer.parseInt(request.getParameter("pos"));	%>
			
			
	
<div class="input-group">
			
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">nombre</span></div> 
<div class="col-md-4"> 	<input type="text" name="nombre" id="nombre" value="<%=clientes.get(pos).getNombre()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div> 
        
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">apellido</span></div>
<div class="col-md-4"> 	<input type="text" name="apellido" id="apellido" value="<%=clientes.get(pos).getApellido()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div> 


<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon2">tipoDoc</span></div> 
<div class="col-md-4">
    <select name="tipoDoc" id="tipoDoc" class="form-control">
    <option value="<%=clientes.get(pos).getTipoDoc()%>"><%=clientes.get(pos).getTipoDoc()%></option>
     <option value="DNI">DNI</option>
     <option value="CI">CI</option>
     <option value="LE">LE</option>
     <option value="LC">LC</option>
    </select>   </div>
</div>       
        
	
        
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">numDoc</span></div>
<div class="col-md-4">  <input type="text" name="numDoc" id="numDoc" value="<%=clientes.get(pos).getNumDoc()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
<div class="col-md-1"> int </div>	
</div>  			 
        
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">telFijo</span></div> 
<div class="col-md-4"> <input type="text" name="telFijo" id="telFijo" value="<%=clientes.get(pos).getTelFijo()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
<div class="col-md-1"> int </div>	
</div>  			 
            
 <div class="row">	 
 <div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">telCel</span></div> 
<div class="col-md-4">	<input type="text" name="telCel" id="telCel" value="<%=clientes.get(pos).getTelCel()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
<div class="col-md-1"> int </div>	
</div>  			 
        
 <div class="row">	
 <div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">direccion</span></div> 
 <div class="col-md-4"> <input type="text" name="direccion" id="direccion" value="<%=clientes.get(pos).getDireccion()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
</div>  			 
        
 <div class="row">	 	
 <div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">ciudad</span></div>
 <div class="col-md-4"> <input type="text" name="ciudad" id="ciudad" value="<%=clientes.get(pos).getCiudad()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
</div>  			 
        
<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">provincia</span></div> 
  <div class="col-md-4">  <input type="text" name="provincia" id="provincia" value="<%=clientes.get(pos).getProvincia()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
</div>  			 
        
 <div class="row">
 <div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">nacionalidad</span></div>
	 <div class="col-md-4">	<input type="text" name="nacionalidad" id="nacionalidad" value="<%=clientes.get(pos).getNacionalidad()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
</div>  			 
        
<div class="row">	
 <div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">E-mail</span></div> 
 <div class="col-md-4"> <input type="text" name="e_mail" id="e_mail" value="<%=clientes.get(pos).getE_mail()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
</div>  			

				
 <div class="row">			
    <div class="col-md-6">
			<fieldset>
				<legend>Aceptar:</legend>
				<input id="clientValidate" type="submit" value="crear" /> 
				<input type="reset" value="cancel" />
			</fieldset>	</div>	</div>
			
</div>
	
		</form>
	
	<br/>	<button class="volverButton"  id="CancelClient">volver</button>
    
   </div>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
      <script type="text/javascript" src="js/validate.js"></script>
	  

</body>
</html>
