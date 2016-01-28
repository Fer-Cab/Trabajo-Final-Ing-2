<%@page import="com.model.Empleado"%>
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
<title>Empleado update page</title>
</head>
<body>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<div id="empleado">

<h2>Modificar Cliente</h2>

<form id="formUpdateClient" action="ModificarClienteServlet" method="post">

<%			
	@SuppressWarnings("unchecked")
	List<Empleado> empleados = (List<Empleado>) session.getAttribute("empleados");
			int pos = Integer.parseInt(request.getParameter("pos"));		%>
			
<div class="input-group">
			
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon3">nombre</span></div>
<div class="col-md-4"> <input type="text" name="nombre" id="nombre" class="form-control"  aria-describedby="basic-addon3" value="<%=empleados.get(pos).getNombre()%>"/><br/></div>
</div>

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">apellido</span></div>
<div class="col-md-4"> <input type="text" name="apellido" id="apellido" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getApellido()%>"/><br/></div>
</div>
	 	
<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon2">tipoDoc</span></div> 
<div class="col-md-4">
    <select name="tipoDoc" id="tipoDoc" class="form-control">
    <option value="<%=empleados.get(pos).getTipoDoc()%>"><%=empleados.get(pos).getTipoDoc()%></option>
     <option value="DNI">DNI</option>
     <option value="CI">CI</option>
     <option value="LE">LE</option>
     <option value="LC">LC</option>
    </select>   </div>
</div>          
		

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">numDoc</span></div>
<div class="col-md-4">  <input type="text" name="numDoc" id="numDoc" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getNumDoc()%>"/><br/></div>
<div class="col-md-1"> int </div>   
</div>              
    

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">telFijo</span></div> 
<div class="col-md-4"> <input type="text" name="telFijo" id="telFijo" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getTelFijo()%>"/><br/></div>
<div class="col-md-1"> int </div>   
</div>              

 <div class="row">   
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">telCel</span></div> 
<div class="col-md-4">  <input type="text" name="telCel" id="telCel" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getTelCel()%>"/><br/></div>
<div class="col-md-1"> int </div>   
</div>              

 <div class="row">  
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">direccion</span></div> 
 <div class="col-md-4">    <input type="text" name="direccion" id="direccion" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getDireccion()%>"/><br/></div>
</div>              

 <div class="row">      
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">ciudad</span></div>
 <div class="col-md-4">     <input type="text" name="ciudad" id="ciudad" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getCiudad()%>"/><br/></div>
</div>               
            
<div class="row">
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">provincia</span></div> 
  <div class="col-md-4">   <input type="text" name="provincia" id="provincia" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getProvincia()%>"/><br/></div>
</div>                
                
 <div class="row">
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">nacionalidad</span></div>
     <div class="col-md-4">     <input type="text" name="nacionalidad" id="nacionalidad" class="form-control" aria-describedby="basic-addon3"  value="<%=empleados.get(pos).getNacionalidad()%>"/><br/></div>
</div>                
            
 <div class="row">  
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">E-mail</span></div> 
     <div class="col-md-4"> <input type="text" name="e_mail" id="e_mail" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getE_mail()%>"/><br/></div>
</div>                

<div class="row">   
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">foto</span></div> 
     <div class="col-md-4"> <input type="text" name="foto" id="foto" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getFoto()%>"/><br/></div>
</div>                

<div class="row">   
 <div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">fechaIngreso</span></div> 
     <div class="col-md-4"> <input type="text" name="fechaIngreso" id="fechaIngreso" class="form-control" aria-describedby="basic-addon3" value="<%=empleados.get(pos).getFechaIngreso()%>"/><br/></div>
</div>                
            
		

				
 <div class="row">			
    <div class="col-md-6">
			<fieldset>
				<legend>Aceptar:</legend>
				<input id="empleadoValidate"  type="submit" value="crear" />
				<input type="reset" value="cancel" />
			</fieldset>	</div>	</div>
			
</div>
	
	</form>
	
    <br/>	<button  class="volverButton" id="CancelEmpleado">volver</button>
		
		<!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
      <script type="text/javascript" src="js/validate.js"></script>
	 
     </div>
      
	</body>
</html>