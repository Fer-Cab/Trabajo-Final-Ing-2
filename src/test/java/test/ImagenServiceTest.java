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
import com.service.ImagenService;
import com.service.InmuebleService;

public class ImagenServiceTest {
	Inmueble inmbl;
	Inmueble inmbl2;
	
	Imagen img;
	Imagen img2;
	Imagen img3;

	Conexion con1;
	Connection con ;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		inmbl = new Inmueble("descripcion", "tipoDeInmueble", "tipoDeOperacion", "tipoDeEstado", "estado", 
				"direccion","1", "d", "ciudad", "provincia", 1, 1, 1, 1.0, 1.0, "tipoSuelo", true, true, true, 1.0);
		inmbl2 = new Inmueble("descripcion2", "tipoDeInmueble2", "tipoDeOperacion2", "tipoDeEstado2", "estado2", "direccion2",
				"2", "e", "ciudad2", "provincia2", 2, 2,  2, 2.0, 2.0, "tipoSuelo2", true, true, true, 2.0);
	
		img = new Imagen("imagen1", "path1",01);
		img2 = new Imagen("imagen2", "path2",02);
		img3 = new Imagen("imagen3", "path3",01);

		con1 = new Conexion();
		con1.initDb();
		 con = Conexion.getConexion();
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