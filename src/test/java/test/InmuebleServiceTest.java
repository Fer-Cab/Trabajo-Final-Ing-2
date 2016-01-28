package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.conexion.Conexion;
import com.model.Imagen;
import com.model.Inmueble;
import com.service.InmuebleService;

public class InmuebleServiceTest {

	Inmueble inmbl;
	Inmueble inmbl2;
	Inmueble inmbl3;
	Imagen img ;
	Imagen img2;
	Imagen img3;
	
	Connection con;
	Conexion con1;


	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		inmbl = new Inmueble("descripcion", "Departamento", "alquiler",  "estado", 
				"direccion","1", "d", "ciudad", "provincia", 1, 1, 1, 1.0, 1.0, "tipoSuelo", true, true, true, 1.0,1);
		inmbl2 = new Inmueble("descripcion2", "casa", "alquiler", "estado2", "direccion2",
				"2", "e", "ciudad2", "provincia2", 2, 2,  2, 2.0, 2.0, "tipoSuelo2", true, true, true, 2.0,1);
		 inmbl3 = new Inmueble("descripcion3", "Oficina", "venta","estado3",
				"direccion", "1", "d", "ciudad3", "provincia3",  3, 3, 3, 3.1, 3.1, "tipoSuelo3", false, false, true, 3.1,1);
	
		
		con1 = new Conexion();
		con1.initDb();
		con = Conexion.getConexion();
		
	}

	@Test
	public void createInmuebleAndFindByDireccionAndPisoAndDptoTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		assertEquals(
				"Inmueble [inmuebleId=1, inmuebleLists=null, descripcion=descripcion, tipoDeInmueble=Departamento, tipoDeOperacion=alquiler, estado=estado, direccion=direccion, piso=1, dpto=d, ciudad=ciudad, provincia=provincia, numHabitaciones=1, banios=1, m2=1, alquiler=1.0, venta=1.0, tipoSuelo=tipoSuelo, garage=true, ascensor=true, amueblado=true, comision=1.0]",
				InmuebleService.findByDireccionAndPisoAndDpto("direccion", "1", "d",con).toString());
	}

	@Test
	public void getAllInmueblesTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		InmuebleService.createInmueble(inmbl2,con);
		assertEquals(
				"[Inmueble [inmuebleId=1, inmuebleLists=null, descripcion=descripcion, tipoDeInmueble=Departamento, tipoDeOperacion=alquiler, estado=estado, direccion=direccion, piso=1, dpto=d, ciudad=ciudad, provincia=provincia, numHabitaciones=1, banios=1, m2=1, alquiler=1.0, venta=1.0, tipoSuelo=tipoSuelo, garage=true, ascensor=true, amueblado=true, comision=1.0], Inmueble [inmuebleId=2, inmuebleLists=null, descripcion=descripcion2, tipoDeInmueble=casa, tipoDeOperacion=alquiler, estado=estado2, direccion=direccion2, piso=2, dpto=e, ciudad=ciudad2, provincia=provincia2, numHabitaciones=2, banios=2, m2=2, alquiler=2.0, venta=2.0, tipoSuelo=tipoSuelo2, garage=true, ascensor=true, amueblado=true, comision=2.0]]",
				InmuebleService.getAllInmuebles(con).toString());
	}

	@Test
	public void updateInmuebleTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		InmuebleService.updateInmueble(inmbl3,con);
		assertEquals(
				"Inmueble [inmuebleId=1, inmuebleLists=null, descripcion=descripcion3, tipoDeInmueble=Oficina, tipoDeOperacion=venta, estado=estado3, direccion=direccion, piso=1, dpto=d, ciudad=ciudad3, provincia=provincia3, numHabitaciones=3, banios=3, m2=3, alquiler=3.1, venta=3.1, tipoSuelo=tipoSuelo3, garage=false, ascensor=false, amueblado=true, comision=3.1]",
				InmuebleService.findByDireccionAndPisoAndDpto("direccion", "1", "d",con).toString());
	}

	@Test
	public void deleteInmuebleTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		InmuebleService.createInmueble(inmbl2,con);
		InmuebleService.deleteInmueble(2l,con);
		assertEquals(
				"[Inmueble [inmuebleId=1, inmuebleLists=null, descripcion=descripcion, tipoDeInmueble=Departamento, tipoDeOperacion=alquiler, estado=estado, direccion=direccion, piso=1, dpto=d, ciudad=ciudad, provincia=provincia, numHabitaciones=1, banios=1, m2=1, alquiler=1.0, venta=1.0, tipoSuelo=tipoSuelo, garage=true, ascensor=true, amueblado=true, comision=1.0]]",
				InmuebleService.getAllInmuebles(con).toString());
	}

}
