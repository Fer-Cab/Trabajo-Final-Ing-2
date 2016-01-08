
$("#accountValidate").click(function(){
	
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var permisos = document.getElementById("permisos").value;
	
	if(!isNaN(userName) || userName.length > 25 || userName.length < 5){
		alert ("el nombre de usuario debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(password) || password.length > 25 || password.length < 5){
		alert ("password debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(permisos.length < 1){
		alert ("el permiso no puede ser vacio");
		return false;
	}

	return true;	
});



$("#clientValidate").click(function(){
	
	var nombre = document.getElementById("nombre").value;
	var apellido = document.getElementById("apellido").value;
	var tipoDoc = document.getElementById("tipoDoc").value;
	var  numDoc = document.getElementById("numDoc").value;
	var  telFijo = document.getElementById("telFijo").value;
	var  telCel = document.getElementById("telCel").value;
	 var direccion = document.getElementById("direccion").value;
	var ciudad = document.getElementById("ciudad").value;
	var provincia = document.getElementById("provincia").value;
	var nacionalidad = document.getElementById("nacionalidad").value;
	var e_mail = document.getElementById("e_mail").value;
		
	if(!isNaN(nombre) || nombre.length > 25 || nombre.length < 2){
		alert ("el nombre debe tener menos de 25 caracteres y mas de 2");
		return false;
	}
	if(!isNaN(apellido) || apellido.length > 25 || apellido.length < 2){
		alert ("el apellido debe tener menos de 25 caracteres y mas de 2");
		return false;
	}
	if(tipoDoc.length < 1){
		alert ("el tipoDoc no puede ser vacio");
		return false;
	}
	if( numDoc.length > 10  || isNaN(numDoc)){
		alert("el numDoc debe ser un numero  menor a 10 caracteres");
		return false;
	}	 
	if( telFijo.length > 10  || isNaN(telFijo)){
		alert("el telFijo debe ser un numero  menor a 10 caracteres");
		return false;
	}
	if( telCel.length > 15  || isNaN(telCel)){
		alert("el telCel debe ser un numero  menor a 15 caracteres");
		return false;
	}
	if(!isNaN(direccion) || direccion.length > 25 || direccion.length < 5){
		alert ("la direccion debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(ciudad) || ciudad.length > 25 || ciudad.length < 5){
		alert ("la ciudad debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(provincia) || provincia.length > 25 || provincia.length < 5){
		alert ("la provincia debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(nacionalidad) || nacionalidad.length > 15 || nacionalidad.length < 5){
		alert ("la nacionalidad debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(e_mail) || e_mail.length > 25 || e_mail.length < 5){
		alert ("el mail debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	
	return true;	
});


$("#empleadoValidate").click(function(){
	
	var nombre = document.getElementById("nombre").value;
	var apellido = document.getElementById("apellido").value;
	var tipoDoc = document.getElementById("tipoDoc").value;
	var  numDoc = document.getElementById("numDoc").value;
	var  telFijo = document.getElementById("telFijo").value;
	var  telCel = document.getElementById("telCel").value;
	 var direccion = document.getElementById("direccion").value;
	var ciudad = document.getElementById("ciudad").value;
	var provincia = document.getElementById("provincia").value;
	var nacionalidad = document.getElementById("nacionalidad").value;
	var e_mail = document.getElementById("e_mail").value;
	var sector = document.getElementById("sector").value;
	var categoria = document.getElementById("categoria").value;
	var fechaIngreso = document.getElementById("fechaIngreso").value;
			 		
	
	if(!isNaN(nombre) || nombre.length > 25 || nombre.length < 2){
		alert ("el nombre debe tener menos de 25 caracteres y mas de 2");
		return false;
	}
	if(!isNaN(apellido) || apellido.length > 25 || apellido.length < 2){
		alert ("el apellido debe tener menos de 25 caracteres y mas de 2");
		return false;
	}
	if(tipoDoc.length < 1){
		alert ("el tipoDoc no puede ser vacio");
		return false;
	}
	if( numDoc.length > 10  || isNaN(numDoc)){
		alert("el numDoc debe ser un numero  menor a 10 caracteres");
		return false;
	}	 
	if( telFijo.length > 10  || isNaN(telFijo)){
		alert("el telFijo debe ser un numero  menor a 10 caracteres");
		return false;
	}
	if( telCel.length > 15  || isNaN(telCel)){
		alert("el telCel debe ser un numero  menor a 15 caracteres");
		return false;
	}
	if(!isNaN(direccion) || direccion.length > 25 || direccion.length < 5){
		alert ("la direccion debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(ciudad) || ciudad.length > 25 || ciudad.length < 5){
		alert ("la ciudad debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(provincia) || provincia.length > 25 || provincia.length < 5){
		alert ("la provincia debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(nacionalidad) || nacionalidad.length > 15 || nacionalidad.length < 5){
		alert ("la nacionalidad debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(e_mail) || e_mail.length > 25 || e_mail.length < 5){
		alert ("el mail debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(sector) || sector.length > 25 || sector.length < 5){
		alert ("el sector debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(categoria) || categoria.length > 25 || categoria.length < 5){
		alert ("la categoria debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(fechaIngreso.length > 11 || fechaIngreso.length < 10){
		alert ("fecha debe ingresarse aaaa-mm-dd");
		return false;
	}
	
	return true;	
});

