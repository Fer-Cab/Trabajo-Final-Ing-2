package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.conexion.Conexion;
import com.model.Cliente;
import com.service.ClienteService;

public class ClienteServiceTest {

	Cliente client;
	Cliente client2;
	Cliente client3;
	Conexion con;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		client = new Cliente("nombre", "apellido", "tipoDoc", 1, 1, 1, "direccion", "ciudad", "provincia",
				"nacionalidad", "e_mail");
		client2 = new Cliente("nombre2", "apellido2", "tipoDoc2", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
				"nacionalidad2", "e_mail2");
		client3 = new Cliente("nombre3", "apellido3", "tipoDoc", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
				"nacionalidad3", "e_mail3");

		con = new Conexion();
		con.initDb();
	}

	@Test
	public void createClienteAndFindByTipoDocAndNumDocTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client);
		assertEquals(
				"Cliente [inmueble=[], clienteId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail]",
				ClienteService.findByTipoDocAndNumDoc("tipoDoc", 1).toString());
	}

	@Test
	public void getAllClientesTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client);
		ClienteService.createCliente(client2);
		assertEquals(
				"[Cliente [inmueble=[], clienteId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail], Cliente [inmueble=[], clienteId=2, nombre=nombre2, apellido=apellido2, tipoDoc=tipoDoc2, numDoc=2, telFijo=2, telCel=2, direccion=direccion2, ciudad=ciudad2, provincia=provincia2, nacionalidad=nacionalidad2, e_mail=e_mail2]]",
				ClienteService.getAllClientes().toString());
	}

	@Test
	public void updateClienteTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client);
		ClienteService.updateCliente(client3);
		assertEquals(
				"Cliente [inmueble=[], clienteId=1, nombre=nombre3, apellido=apellido3, tipoDoc=tipoDoc, numDoc=1, telFijo=3, telCel=3, direccion=direccion3, ciudad=ciudad3, provincia=provincia3, nacionalidad=nacionalidad3, e_mail=e_mail3]",
				ClienteService.findByTipoDocAndNumDoc("tipoDoc", 1).toString());
	}

	@Test
	public void deleteClienteTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client);
		ClienteService.createCliente(client2);
		ClienteService.deleteCliente(2l);
		assertEquals("[Cliente [inmueble=[], clienteId=1, nombre=nombre, apellido=apellido, tipoDoc=tipoDoc, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail]]",
				ClienteService.getAllClientes().toString());
	}

}
