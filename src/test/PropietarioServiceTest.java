package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.conexion.Conexion;
import com.model.Propietario;
import com.service.PropietarioService;

public class PropietarioServiceTest {

	Propietario prop;
	Propietario prop2;
	Propietario prop3;
	Conexion con;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		prop = new Propietario("nombre", "apellido", "tipoDoc", 1, 1, 1, "direccion", "ciudad", "provincia",
				"nacionalidad", "e_mail", "numCuenta");
		prop2 = new Propietario("nombre2", "apellido2", "tipoDoc2", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
				"nacionalidad2", "e_mail2", "numCuenta2");
		prop3 = new Propietario("nombre3", "apellido3", "tipoDoc", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
				"nacionalidad3", "e_mail3", "numCuenta3");

		con = new Conexion();
		con.initDb();
	}

	@Test
	public void createPropietarioAndFindByTipoDocAndNumDocTest()
			throws ClassNotFoundException, SQLException, IOException {
		PropietarioService.createPropietario(prop);
		assertEquals(
				"Propietario [inmuebles=[], propietarioId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, numCuenta=numCuenta]",
				PropietarioService.findByTipoDocAndNumDoc("tipoDoc", 1).toString());
	}

	@Test
	public void getAllPropietariosTest() throws ClassNotFoundException, SQLException, IOException {
		PropietarioService.createPropietario(prop);
		PropietarioService.createPropietario(prop2);
		assertEquals(
				"[Propietario [inmuebles=[], propietarioId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, numCuenta=numCuenta], Propietario [inmuebles=[], propietarioId=2, nombre=nombre2, apellido=apellido2, tipoDoc=tipoDoc2, numDoc=2, telFijo=2, telCel=2, direccion=direccion2, ciudad=ciudad2, provincia=provincia2, nacionalidad=nacionalidad2, e_mail=e_mail2, numCuenta=numCuenta2]]",
				PropietarioService.getAllPropietarios().toString());
	}

	@Test
	public void updatePropietarioTest() throws ClassNotFoundException, SQLException, IOException {
		PropietarioService.createPropietario(prop);
		PropietarioService.updatePropietario(prop3);
		assertEquals(
				"Propietario [inmuebles=[], propietarioId=1, nombre=nombre3, apellido=apellido3, tipoDoc=tipoDoc, numDoc=1, telFijo=3, telCel=3, direccion=direccion3, ciudad=ciudad3, provincia=provincia3, nacionalidad=nacionalidad3, e_mail=e_mail3, numCuenta=numCuenta3]",
				PropietarioService.findByTipoDocAndNumDoc("tipoDoc", 1).toString());
	}

	@Test
	public void deletePropietarioTest() throws ClassNotFoundException, SQLException, IOException {
		PropietarioService.createPropietario(prop);
		PropietarioService.createPropietario(prop2);
		PropietarioService.deletePropietario(2l);
		assertEquals(
				"[Propietario [inmuebles=[], propietarioId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, numCuenta=numCuenta]]",
				PropietarioService.getAllPropietarios().toString());
	}

}
