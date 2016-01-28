package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.conexion.Conexion;
import com.model.Empleado;
import com.service.EmpleadoService;

public class EmpleadoServiceTest {

	Empleado empleado;
	Empleado empleado2;
	Empleado empleado3;
	Conexion con1;
	Connection con;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		empleado = new Empleado("nombre", "apellido", "DNI", 1, 1, 1, "direccion", "ciudad", "provincia",
				"nacionalidad", "e_mail","foto","2000-05-09");
		empleado2 = new Empleado("nombre2", "apellido2", "LC", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
				"nacionalidad2", "e_mail2","foto2","1995-02-10");
		empleado3 = new Empleado("nombre3", "apellido3", "DNI", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
				"nacionalidad3", "e_mail3","foto3","1998-10-10");
		
		con1 = new Conexion();
		con1.initDb();
		 con = Conexion.getConexion();
	}

	@Test
	public void createEmpleadoAndFindByTipoDocAndNumDocTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		assertEquals(
				"Empleado [empleadoId=2, nombre=nombre, apellido=apellido, tipoDoc=DNI, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, foto=foto, fechaIngreso=2000-05-09]",
				EmpleadoService.findByTipoDocAndNumDoc("DNI", 1,con).toString());
	}

	@Test
	public void getAllEmpleadosTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		EmpleadoService.createEmpleado(empleado2,con);
		assertEquals(
				"[Empleado [empleadoId=2, nombre=nombre, apellido=apellido, tipoDoc=DNI, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, foto=foto, fechaIngreso=2000-05-09], Empleado [empleadoId=3, nombre=nombre2, apellido=apellido2, tipoDoc=LC, numDoc=2, telFijo=2, telCel=2, direccion=direccion2, ciudad=ciudad2, provincia=provincia2, nacionalidad=nacionalidad2, e_mail=e_mail2, foto=foto2, fechaIngreso=1995-02-10]]",
				EmpleadoService.getAllEmpleados(con).toString());
	}

	@Test
	public void updateEmpleadoTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		EmpleadoService.updateEmpleado(empleado3,con);
		assertEquals(
				"Empleado [empleadoId=2, nombre=nombre3, apellido=apellido3, tipoDoc=DNI, numDoc=1, telFijo=3, telCel=3, direccion=direccion3, ciudad=ciudad3, provincia=provincia3, nacionalidad=nacionalidad3, e_mail=e_mail3, foto=foto3, fechaIngreso=1998-10-10]",
				EmpleadoService.findByTipoDocAndNumDoc("DNI", 1,con).toString());
	}

	@Test
	public void deleteEmpleadoTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		EmpleadoService.createEmpleado(empleado2,con);
		EmpleadoService.deleteEmpleado(3l,con);
		assertEquals("[Empleado [empleadoId=2, nombre=nombre, apellido=apellido, tipoDoc=DNI, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, foto=foto, fechaIngreso=2000-05-09]]",
				EmpleadoService.getAllEmpleados(con).toString());
	}

}
