
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
	
	var arr = [userName,password,permisos];
	
	var iChars = "!#$%^&*()+=[]\\\';,./{}|\":<>?";
	
		for ( var  i = 0; i < arr.length; i++) {
			
			for (var j = 0; j < arr[i].length; j++) {
				if (iChars.indexOf(arr[i].charAt(j)) != -1) {
					alert ("Your input has special characters. \n These are not allowed."+
								"\n Please remove them and try again.");
					return false;
				}
			}
			
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
	
	var arr = [nombre , apellido , tipoDoc ,  numDoc ,  telFijo ,  telCel ,
					direccion , ciudad , provincia , nacionalidad , e_mail ];
	
	var iChars = "!#$%^&*()+=[]\\\';,./{}|\":<>?";
	
		for ( var  i = 0; i < arr.length; i++) {
			
			for (var j = 0; j < arr[i].length; j++) {
				if (iChars.indexOf(arr[i].charAt(j)) != -1) {
					alert ("Your input has special characters. \n These are not allowed."+
								"\n Please remove them and try again.");
					return false;
				}
			}
			
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
	
	var arr = [nombre , apellido , tipoDoc ,  numDoc ,  telFijo ,  telCel ,
				 direccion , ciudad , provincia , nacionalidad , e_mail , sector ,
							categoria , fechaIngreso  ];
	
	var iChars = "!#$%^&*()+=[]\\\';,./{}|\":<>?";
	
		for ( var  i = 0; i < arr.length; i++) {
			
			for (var j = 0; j < arr[i].length; j++) {
				if (iChars.indexOf(arr[i].charAt(j)) != -1) {
					alert ("Your input has special characters. \n These are not allowed."+
								"\n Please remove them and try again.");
					return false;
				}
			}
			
		}
		
	return true;	
});

$("#propietarioValidate").click(function(){
	
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
	var numCuenta = document.getElementById("numCuenta").value;
	
	
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
	if(isNaN(numCuenta) || numCuenta.length > 23 || numCuenta.length < 14 ){
		alert ("el numCuenta debe tener menos de 23 caracteres y mas de 14");
		return false;
	}
	
	var arr = [nombre , apellido , tipoDoc ,  numDoc ,  telFijo ,  telCel ,
				 direccion , ciudad , provincia , nacionalidad , e_mail , numCuenta  ];
	
	var iChars = "!#$%^&*()+=[]\\\';,./{}|\":<>?";
	
		for ( var  i = 0; i < arr.length; i++) {
			
			for (var j = 0; j < arr[i].length; j++) {
				if (iChars.indexOf(arr[i].charAt(j)) != -1) {
					alert ("Your input has special characters. \n These are not allowed."+
								"\n Please remove them and try again.");
					return false;
				}
			}
			
		}
		
		
	return true;	
});

		
$("#inmuebleValidate").click(function(){
	
	var descripcion = document.getElementById("descripcion").value;
	var tipoDeInmueble = document.getElementById("tipoDeInmueble").value;
	var tipoDeOperacion = document.getElementById("tipoDeOperacion").value;
	var estado = document.getElementById("estado").value;
	var direccion = document.getElementById("direccion").value;
	var  piso = document.getElementById("piso").value;
	var  dpto = document.getElementById("dpto").value;
	var ciudad = document.getElementById("ciudad").value;
	var provincia = document.getElementById("provincia").value;
	var numHabitaciones = document.getElementById("numHabitaciones").value;
	var banios = document.getElementById("banios").value;
	var m2 = document.getElementById("m2").value;
	var alquiler = document.getElementById("alquiler").value;
	var venta = document.getElementById("venta").value;
	var tipoSuelo = document.getElementById("tipoSuelo").value;
	var comision = document.getElementById("comision").value;	
	
	if(!isNaN(descripcion) || descripcion.length > 100 || descripcion.length < 2){
		alert ("la descripcion debe tener menos de 100 caracteres y mas de 2");
		return false;
	}
	if(!isNaN(tipoDeInmueble) || tipoDeInmueble.length > 12 || tipoDeInmueble.length < 4){
		alert ("el tipoDeInmueble debe tener menos de 12 caracteres y mas de 4");
		return false;
	}
	if(!isNaN(tipoDeOperacion) || tipoDeOperacion.length > 8 || tipoDeOperacion.length < 4){
		alert ("el tipoDeOperacion debe tener menos de 8 caracteres y mas de 4");
		return false;
	}
	if(!isNaN(estado) || estado.length > 21 || estado.length < 5){
		alert ("el estado debe tener menos de 21 caracteres y mas de 5");
		return false;
	}
	if(!isNaN(direccion) || direccion.length > 25 || direccion.length < 5){
		alert ("la direccion debe tener menos de 25 caracteres y mas de 5");
		return false;
	}
	if(piso.length < 1 || piso.length > 2  || isNaN(piso)){
		alert ("el piso no puede ser vacio , el piso no puede ser mayor a 1 caracter");
		return false;
	}
	if( dpto.length < 1 || dpto.length > 2 ){
		alert("el dpto no  puede ser mayor a 1 caracter , ni vacio");
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
	if(isNaN(numHabitaciones) || numHabitaciones.length > 2 || numHabitaciones.length < 1 ){
		alert ("el numHabitaciones no  puede ser mayor a 1 caracter , ni vacio");
		return false;
	}
	if( isNaN(banios) || banios.length > 2 || banios.length < 1 ){
		alert("la cantidad de baños no  puede ser mayor a 1 caracter , ni vacio");
		return false;
	}
	if(isNaN(m2) || m2.length > 3 || m2.length < 1 ){
		alert ("los m2 no  puede ser mayor a 3 caracteres , ni vacio");
		return false;
	}
	if( alquiler.length > 7  || isNaN(alquiler) || alquiler.length < 3 ){
		alert("el alquiler debe tener menos de 7 caracteres y mas de 3");
		return false;
	} 
	if( venta.length > 7  || isNaN(venta) || venta.length < 3 ){
		alert("venta debe tener menos de 7 caracteres y mas de 3");
		return false;
	}
	if(!isNaN(tipoSuelo) || tipoSuelo.length > 9 || tipoSuelo.length < 7){
		alert ("el tipoSuelo debe tener menos de 9 caracteres y mas de 7");
		return false;
	}
	if( comision.length > 7  || isNaN(comision) || comision.length < 3 ){
		alert("la comision debe tener menos de 7 caracteres y mas de 3");
		return false;
	} 
	
	var arr = [ descripcion ,tipoDeInmueble , tipoDeOperacion , estado , direccion ,  piso 
				,  dpto	, ciudad , provincia , numHabitaciones , banios , m2 , alquiler 
					, venta , tipoSuelo , comision ];
	
	var iChars = "!#$%^&*()+=[]\\\';,./{}|\":<>?";
	
		for ( var  i = 0; i < arr.length; i++) {
			
			for (var j = 0; j < arr[i].length; j++) {
				if (iChars.indexOf(arr[i].charAt(j)) != -1) {
					alert ("Your input has special characters. \n These are not allowed."+
								"\n Please remove them and try again.");
					return false;
				}
			}
			
		}
		
	return true;	
});


$("input").keypress(function(e){
   
	/*	   ascii 
		32  _ space  ,	45     -	,	48 - 57 _ num 0-9
		64-90  _ @ _  A-Z	,	95		_     ,		97-122  _ a-z
		209  	-  Ñ	,	225 - á		,	233 _  é
		237	-	í	,	241  -   ñ	,	243-250  _ óú			*/

    var code = e.which || e.keyCode;
	
    if(!( code == 32 || code == 45 || (code >= 48 && code <= 57) || (code >= 64 && code <= 90) || 
			code == 95 || 	(code >= 97 && code <= 122) || code == 209 || code == 225 || code == 233
				||	code == 237 ||	code == 241 ||	code == 243 ||	code == 250 ))
        e.preventDefault();
});




