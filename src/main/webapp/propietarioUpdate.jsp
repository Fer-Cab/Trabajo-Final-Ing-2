<%@page import="com.model.Propietario"%>
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

    <link rel="stylesheet" href="css/aside.css" />
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Propietario update page</title>
</head>
<body>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<div id="propietario">

<h2>Modificar Propietario</h2>

<form id="formUpdatePropietario" action="PropietarioUpdateServlet" method="post">

<%
		@SuppressWarnings("unchecked")
		List<Propietario> propietarios = (List<Propietario>) session.getAttribute("propietarios");
			int pos = Integer.parseInt(request.getParameter("pos"));		%>
			
    
<div class="input-group">
			
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">nombre</span></div> 
<div class="col-md-4"> <input type="text" name="nombre"id="nombre" value="<%=propietarios.get(pos).getNombre()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">apellido</span></div>
<div class="col-md-4"> <input type="text" name="apellido" id="apellido" value="<%=propietarios.get(pos).getApellido()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon2">tipoDoc</span></div> 
<div class="col-md-4">
    <select name="tipoDoc" id="tipoDoc" class="form-control">
    <option value="<%=propietarios.get(pos).getTipoDoc()%>"><%=propietarios.get(pos).getTipoDoc()%></option>
     <option value="DNI">DNI</option>
     <option value="CI">CI</option>
     <option value="LE">LE</option>
     <option value="LC">LC</option>
    </select>   </div>
</div>           			

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">numDoc</span></div>
<div class="col-md-4"> <input type="text" name="numDoc" id="numDoc" value="<%=propietarios.get(pos).getNumDoc()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
<div class="col-md-1"> int </div>	
</div>  			 

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">telFijo</span></div>
<div class="col-md-4"> <input type="text" name="telFijo" id="telFijo" value="<%=propietarios.get(pos).getTelFijo()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
<div class="col-md-1"> int </div>	
</div>  			 

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">telCel</span></div>
<div class="col-md-4"> <input type="text" name="telCel" id="telCel" value="<%=propietarios.get(pos).getTelCel()%>" class="form-control" aria-describedby="basic-addon3"/><br/></div>
<div class="col-md-1"> int </div>	
</div>  			 

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">direccion</span></div>
<div class="col-md-4"> <input type="text" name="direccion" id="direccion" value="<%=propietarios.get(pos).getDireccion()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>
 
<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">ciudad</span></div>
<div class="col-md-4"> <input type="text" name="ciudad" id="ciudad" value="<%=propietarios.get(pos).getCiudad()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>
 

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">provincia</span></div>
<div class="col-md-4"> <input type="text" name="provincia" id="provincia" value="<%=propietarios.get(pos).getProvincia()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>
 

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">nacionalidad</span></div>
<div class="col-md-4"> <input type="text" name="nacionalidad" id="nacionalidad" value="<%=propietarios.get(pos).getNacionalidad()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>
 

<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">E-mail</span></div>
<div class="col-md-4"> <input type="text" name="e_mail" id="e_mail" value="<%=propietarios.get(pos).getE_mail()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>


<div class="row">
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">numero de Cuenta</span></div>
<div class="col-md-4"> <input type="text" name="numCuenta" id="numCuenta" value="<%=propietarios.get(pos).getNumCuenta()%>" class="form-control"  aria-describedby="basic-addon3"/><br/></div>
</div>

			
 <div class="row">			
    <div class="col-md-6">
			<fieldset>
				<legend>Aceptar:</legend>
			<input id="propietarioValidate" type="submit" value="crear"/>
				<input type="reset" value="cancel" />
			</fieldset>	</div>	</div>
			
</div>
	
	</form>
    
<br/>		<button class="volverButton"  id="CancelProp">volver</button>

</div>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
	  
	</body>
</html>