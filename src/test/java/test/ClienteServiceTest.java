package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
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
	Conexion con1 ;
	Connection con ;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		client = new Cliente("nombre", "apellido", "DNI", 1, 1, 1, "direccion", "ciudad", "provincia",
				"nacionalidad", "e_mail");
		client2 = new Cliente("nombre2", "apellido2", "DNI", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
				"nacionalidad2", "e_mail2");
		client3 = new Cliente("nombre3", "apellido3", "DNI", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
				"nacionalidad3", "e_mail3");

		con1 = new Conexion();
		con1.initDb();
		 con = Conexion.getConexion();
		
		// con = (Connection) request.getSession().getAttribute("h2.connection");
	}

	@Test
	public void createClienteAndFindByTipoDocAndNumDocTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client,con);
		assertEquals(
				"Cliente [inmueble=[], clienteId=1, nombre=nombre, apellido=apellido, tipoDoc=DNI, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail]",
				ClienteService.findByTipoDocAndNumDoc("DNI", 1,con).toString());
	}

	@Test
	public void getAllClientesTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client,con);
		ClienteService.createCliente(client2,con);
		assertEquals(
				"[Cliente [inmueble=[], clienteId=1, nombre=nombre, apellido=apellido, tipoDoc=DNI, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail], Cliente [inmueble=[], clienteId=2, nombre=nombre2, apellido=apellido2, tipoDoc=DNI, numDoc=2, telFijo=2, telCel=2, direccion=direccion2, ciudad=ciudad2, provincia=provincia2, nacionalidad=nacionalidad2, e_mail=e_mail2]]",
				ClienteService.getAllClientes(con).toString());
	}

	@Test
	public void updateClienteTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client,con);
		ClienteService.updateCliente(client3,con);
		assertEquals(
				"Cliente [inmueble=[], clienteId=1, nombre=nombre3, apellido=apellido3, tipoDoc=DNI, numDoc=1, telFijo=3, telCel=3, direccion=direccion3, ciudad=ciudad3, provincia=provincia3, nacionalidad=nacionalidad3, e_mail=e_mail3]",
				ClienteService.findByTipoDocAndNumDoc("DNI", 1,con).toString());
	}

	@Test
	public void deleteClienteTest() throws ClassNotFoundException, SQLException, IOException {
		ClienteService.createCliente(client,con);
		ClienteService.createCliente(client2,con);
		ClienteService.deleteCliente(2l,con);
		assertEquals("[Cliente [inmueble=[], clienteId=1, nombre=nombre, apellido=apellido, tipoDoc=DNI, numDoc=1, telFijo=1, telCel=1, direccion=direccion, ciudad=ciudad, provincia=provincia, nacionalidad=nacionalidad, e_mail=e_mail]]",
				ClienteService.getAllClientes(con).toString());
	}

}
