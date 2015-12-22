package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

import com.conexion.Conexion;
import com.model.Imagen;
import com.service.ImagenService;

public class ImagenServiceTest {
	Imagen img;
	Imagen img2;
	Imagen img3;

	Conexion con1;
	Connection con ;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		img = new Imagen("imagen1", "path1");
		img2 = new Imagen("imagen2", "path2");
		img3 = new Imagen("imagen3", "path3");

		con1 = new Conexion();
		con1.initDb();
		 con = Conexion.getConexion();
	}

	@Test
	public void createImagenAndFindByNombreTest() throws ClassNotFoundException, SQLException, IOException {
		ImagenService.createImagen(img);
		assertEquals("Imagen [imagenId=1, nombre=imagen1, path=path1]",
				ImagenService.findByNombre("imagen1").toString());
	}

	@Test
	public void getAllImagensTest() throws ClassNotFoundException, SQLException, IOException {
		ImagenService.createImagen(img);
		ImagenService.createImagen(img2);
		assertEquals(
				"[Imagen [imagenId=1, nombre=imagen1, path=path1], Imagen [imagenId=2, nombre=imagen2, path=path2]]",
				ImagenService.getAllImagenes().toString());
	}

	@Test
	public void updateImagenTest() throws ClassNotFoundException, SQLException, IOException {
		ImagenService.createImagen(img);
		ImagenService.updateImagen("imagen1",img3);

		assertEquals("Imagen [imagenId=1, nombre=imagen3, path=path3]",
				ImagenService.findByNombre("imagen3").toString());
	}

	@Test
	public void deleteImagenTest() throws ClassNotFoundException, SQLException, IOException {
		ImagenService.createImagen(img);
		ImagenService.createImagen(img2);
		ImagenService.deleteImagen(2l);
		assertEquals("[Imagen [imagenId=1, nombre=imagen1, path=path1]]", ImagenService.getAllImagenes().toString());
	}

}