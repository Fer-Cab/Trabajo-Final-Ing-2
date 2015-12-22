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
		empleado = new Empleado("nombre", "apellido", "tipoDoc", 1, 1, 1, "direccion", "ciudad", "provincia",
				"nacionalidad", "e_mail","foto","sector","categoria","fechaIngreso");
		empleado2 = new Empleado("nombre2", "apellido2", "tipoDoc2", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
				"nacionalidad2", "e_mail2","foto2","sector2","categoria2","fechaIngreso2");
		empleado3 = new Empleado("nombre3", "apellido3", "tipoDoc", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
				"nacionalidad3", "e_mail3","foto3","sector3","categoria3","fechaIngreso3");
		
		con1 = new Conexion();
		con1.initDb();
		 con = Conexion.getConexion();
	}

	@Test
	public void createEmpleadoAndFindByTipoDocAndNumDocTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		assertEquals(
				"Empleado [empleadoId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, foto=foto, sector=sector, categoria=categoria, fechaIngreso=fechaIngreso]",
				EmpleadoService.findByTipoDocAndNumDoc("tipoDoc", 1,con).toString());
	}

	@Test
	public void getAllEmpleadosTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		EmpleadoService.createEmpleado(empleado2,con);
		assertEquals(
				"[Empleado [empleadoId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, foto=foto, sector=sector, categoria=categoria, fechaIngreso=fechaIngreso], Empleado [empleadoId=2, nombre=nombre2, apellido=apellido2, tipoDoc=tipoDoc2, numDoc=2, telFijo=2, telCel=2, direccion=direccion2, ciudad=ciudad2, provincia=provincia2, nacionalidad=nacionalidad2, e_mail=e_mail2, foto=foto2, sector=sector2, categoria=categoria2, fechaIngreso=fechaIngreso2]]",
				EmpleadoService.getAllEmpleados(con).toString());
	}

	@Test
	public void updateEmpleadoTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		EmpleadoService.updateEmpleado(empleado3,con);
		assertEquals(
				"Empleado [empleadoId=1, nombre=nombre3, apellido=apellido3, tipoDoc=tipoDoc, numDoc=1, telFijo=3, telCel=3, direccion=direccion3, ciudad=ciudad3, provincia=provincia3, nacionalidad=nacionalidad3, e_mail=e_mail3, foto=foto3, sector=sector3, categoria=categoria3, fechaIngreso=fechaIngreso3]",
				EmpleadoService.findByTipoDocAndNumDoc("tipoDoc", 1,con).toString());
	}

	@Test
	public void deleteEmpleadoTest() throws ClassNotFoundException, SQLException, IOException {
		EmpleadoService.createEmpleado(empleado,con);
		EmpleadoService.createEmpleado(empleado2,con);
		EmpleadoService.deleteEmpleado(2l,con);
		assertEquals("[Empleado [empleadoId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail, foto=foto, sector=sector, categoria=categoria, fechaIngreso=fechaIngreso]]",
				EmpleadoService.getAllEmpleados(con).toString());
	}

}
