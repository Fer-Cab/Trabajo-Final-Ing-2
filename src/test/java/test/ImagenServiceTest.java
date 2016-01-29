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
import com.model.Propietario;
import com.service.ImagenService;
import com.service.InmuebleService;
import com.service.PropietarioService;

public class ImagenServiceTest {
	Propietario prop;
	
	Inmueble inmbl;
	Inmueble inmbl2;
	
	Imagen img;
	Imagen img2;
	Imagen img3;

	Conexion con1;
	Connection con ;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		prop = new Propietario("nombre", "apellido", "DNI", 1, 1, 1, "direccion", "ciudad", "provincia",
				"nacionalidad", "e_mail", "numCuenta");
		inmbl = new Inmueble("descripcion", "Departamento", "alquiler",  "estado", 
				"direccion","1", "d", "ciudad", "provincia", 1, 1, 1, 1.0, 1.0, "tipoSuelo", true, true, true, 1.0, "DNI", 1);
		inmbl2 = new Inmueble("descripcion2", "casa", "alquiler", "estado2", "direccion2",
				"2", "e", "ciudad2", "provincia2", 2, 2,  2, 2.0, 2.0, "tipoSuelo2", true, true, true, 2.0, "DNI", 1);
	
		img = new Imagen("imagen1", "path1",01);
		img2 = new Imagen("imagen2", "path2",02);
		img3 = new Imagen("imagen3", "path3",01);

		con1 = new Conexion();
		con1.initDb();
		con = Conexion.getConexion();
		 
		PropietarioService.createPropietario(prop,con);
	}

	@Test
	public void createImagenAndFindByNombreTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		ImagenService.createImagen(img);
		assertEquals("Imagen [imagenId=1, nombre=imagen1, path=path1, inmuebleId=1]",
				ImagenService.findByNombre("imagen1").toString());
	}

	@Test
	public void getAllImagensTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		InmuebleService.createInmueble(inmbl2,con);
		ImagenService.createImagen(img);
		ImagenService.createImagen(img2);

		assertEquals(
				"[Imagen [imagenId=1, nombre=imagen1, path=path1, inmuebleId=1], Imagen [imagenId=2, nombre=imagen2, path=path2, inmuebleId=2]]",
				ImagenService.getAllImagenes().toString());
	}

	@Test
	public void updateImagenTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		ImagenService.createImagen(img);
		ImagenService.updateImagen("imagen1",img3);

		assertEquals("Imagen [imagenId=1, nombre=imagen3, path=path3, inmuebleId=1]",
				ImagenService.findByNombre("imagen3").toString());
	}

	@Test
	public void deleteImagenTest() throws ClassNotFoundException, SQLException, IOException {
		InmuebleService.createInmueble(inmbl,con);
		InmuebleService.createInmueble(inmbl2,con);
		ImagenService.createImagen(img);
		ImagenService.createImagen(img2);
		ImagenService.deleteImagen(2l);
		assertEquals("[Imagen [imagenId=1, nombre=imagen1, path=path1, inmuebleId=1]]", ImagenService.getAllImagenes().toString());
	}

}