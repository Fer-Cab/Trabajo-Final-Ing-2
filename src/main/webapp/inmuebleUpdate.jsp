<%@page import="com.model.Inmueble"%>
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
<title>Inmueble update page</title>
</head>
<body>
<%@page isErrorPage="false" errorPage="Error.jsp"%>

<div id="inmueble">

<h2>Modificar Inmueble</h2>

<form id="formUpdateInmueble" action="InmuebleUpdateServlet" method="post">

<%
		@SuppressWarnings("unchecked")
		List<Inmueble> inmuebles = (List<Inmueble>) session.getAttribute("inmuebles");
			int pos = Integer.parseInt(request.getParameter("pos"));		%>
			
		  
        <div class="input-group">
            
<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">descripcion</span></div>
    <div class="col-md-4">  <input type="text" name="descripcion" id="descripcion"  class="form-control"  aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getDescripcion()%>"/><br/></div>
</div>

<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">tipoDeInmueble</span></div> 
<div class="col-md-4">
	<select name="tipoDeInmueble" id="tipoDeInmueble" class="form-control">
	<option value="<%=inmuebles.get(pos).getTipoDeInmueble()%>"><%=inmuebles.get(pos).getTipoDeInmueble()%></option>
	 <option value="Casa">Casa</option>
	 <option value="Cochera">Cochera</option>
	 <option value="Departamento">Departamento</option>
	 <option value="Galpon">Galpon</option>
	 <option value="Local">Local</option>
	 <option value="Oficina">Oficina</option>	 
	 <option value="Terreno">Terreno</option>	 
	</select>	</div>
</div> 

<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">tipoDeOperacion</span></div> 
<div class="col-md-4">
	<select name="tipoDeOperacion" id="tipoDeOperacion" class="form-control">
	<option value="<%=inmuebles.get(pos).getTipoDeOperacion()%>"><%=inmuebles.get(pos).getTipoDeOperacion()%></option>
	 <option value="alquiler">alquiler</option>
	 <option value="venta">venta</option>
	</select>	</div>
</div>

<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">estado</span></div> 
<div class="col-md-4">
	<select name="estado" id="estado" class="form-control">
	<option value="<%=inmuebles.get(pos).getEstado()%>"><%=inmuebles.get(pos).getEstado()%></option>
	 <option value="nuevo">nuevo</option>
	 <option value="menos de 10 años">menos de 10 años</option>
	 <option value="reciente">reciente (de 10 a 50)</option>
	 <option value="antiguo">antiguo (mas de 50)</option>
	</select>	</div>
</div> 

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">direccion</span></div>
    <div class="col-md-4">  <input type="text" name="direccion" id="direccion"  class="form-control"  aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getDireccion()%>"/><br/></div>
</div>

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">piso</span></div>
    <div class="col-md-4">  <input type="text" name="piso" id="piso"  class="form-control"  aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getPiso()%>"/><br/></div>
</div>

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">dpto</span></div>
    <div class="col-md-4">  <input type="text" name="dpto" id="dpto"  class="form-control"  aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getDpto()%>"/><br/></div>
</div>

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">ciudad</span></div>
    <div class="col-md-4">  <input type="text" name="ciudad" id="ciudad"  class="form-control"  aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getCiudad()%>"/><br/></div>
</div>

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">provincia</span></div>
    <div class="col-md-4">  <input type="text" name="provincia" id="provincia" class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getProvincia()%>"/><br/></div>
</div>              

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">numHabitaciones</span></div>
    <div class="col-md-4">  <input type="text" name="numHabitaciones" id="numHabitaciones" class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getNumHabitaciones()%>"/><br/></div>
<div class="col-md-1"> int </div>   
</div>               

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">banios</span></div>
    <div class="col-md-4">  <input type="text" name="banios" id="banios"class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getBanios()%>"/><br/></div>
<div class="col-md-1"> int </div>   
</div>              
 
<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">metros cuadrados</span></div>
    <div class="col-md-4">  <input type="text" name="m2" id="m2"class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getM2()%>"/><br/></div>
<div class="col-md-1"> int </div>   
</div>              
 
<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">alquiler</span></div>
    <div class="col-md-4">  <input type="text" name="alquiler" id="alquiler"class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getAlquiler()%>"/><br/></div>
<div class="col-md-1"> double </div>   
</div>           


<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">venta</span></div>
    <div class="col-md-4">  <input type="text" name="venta" id="venta"class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getVenta()%>"/><br/></div>
<div class="col-md-1"> double </div>   
</div>              

 
<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">tipoSuelo</span></div> 
<div class="col-md-4">
	<select name="tipoSuelo" id="tipoSuelo" class="form-control">
	<option value="<%=inmuebles.get(pos).getTipoSuelo()%>"><%=inmuebles.get(pos).getTipoSuelo()%></option>
	 <option value="ceramico">ceramico</option>
	 <option value="parquet">parquet</option>
	</select>	</div>
</div>  	             

<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">garage</span></div> 
<div class="col-md-4">
	<select name="garage" id="garage" class="form-control">
	<option value="<%=inmuebles.get(pos).isGarage()%>"><%=inmuebles.get(pos).isGarage()%></option>
	 <option value="si">si</option>
	 <option value="no">no</option>
	</select>	</div>
</div>                

<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">ascensor</span></div> 
<div class="col-md-4">
	<select name="ascensor" id="ascensor" class="form-control">
	<option value="<%=inmuebles.get(pos).isAscensor()%>"><%=inmuebles.get(pos).isAscensor()%></option>
	 <option value="si">si</option>
	 <option value="no">no</option>
	</select>	</div>
</div>             

<div class="row">	
<div class="col-md-2">
	<span class="input-group-addon" id="basic-addon2">amueblado</span></div> 
<div class="col-md-4">
	<select name="amueblado" id="amueblado" class="form-control">
	<option value="<%=inmuebles.get(pos).isAmueblado()%>"><%=inmuebles.get(pos).isAmueblado()%></option>
	 <option value="si">si</option>
	 <option value="no">no</option>
	</select>	</div>
</div>             

<div class="row">   
<div class="col-md-2">
    <span class="input-group-addon" id="basic-addon3">comision</span></div>
    <div class="col-md-4">  <input type="text" name="comision" id="comision"class="form-control" aria-describedby="basic-addon3" value="<%=inmuebles.get(pos).getComision()%>"/><br/></div>
<div class="col-md-1"> double </div>   
</div>            

			
 <div class="row">			
    <div class="col-md-6">
			<fieldset>
				<legend>Aceptar:</legend>
				<input id="inmuebleValidate" type="submit" value="crear"/>
				<input type="reset" value="cancel" />
			</fieldset>	</div>	</div>
			
</div>
    
    </form>
        
<br/>       <button  class="volverButton" id="CancelInmueble">volver</button> 

</div>
        
        <!-- jQuery -->
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
        <script type="text/javascript" src="js/validate.js"></script>
</body>      
</html>
