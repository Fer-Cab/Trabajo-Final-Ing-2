package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Cliente;

public class ClienteService {

	public static void createCliente(Cliente cliente , Connection con) throws ClassNotFoundException, SQLException, IOException {

	//	Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement(
				"insert into Cliente(nombre, apellido ,tipoDoc ,numDoc ,telFijo ,telCel ,direccion ,ciudad ,provincia "
				+ ",nacionalidad ,e_mail)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setString(3, cliente.getTipoDoc());
		ps.setInt(4, cliente.getNumDoc());
		ps.setInt(5, cliente.getTelFijo());
		ps.setInt(6, cliente.getTelCel());
		ps.setString(7, cliente.getDireccion());
		ps.setString(8, cliente.getCiudad());
		ps.setString(9, cliente.getProvincia());
		ps.setString(10, cliente.getNacionalidad());
		ps.setString(11, cliente.getE_mail());
		ps.execute();
	}

	public static Cliente findByTipoDocAndNumDoc(String tipoDoc, int numDoc ,Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		//Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cliente WHERE tipoDoc = ? and numDoc =?");
		ps.setString(1, tipoDoc);
		ps.setInt(2, numDoc);

		ResultSet rs = ps.executeQuery();
		Cliente client = null;

		if (rs.next()) {
			client = new Cliente(rs.getLong("clienteId"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("tipoDoc"), rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"),
					rs.getString("direccion"), rs.getString("ciudad"), rs.getString("provincia"),
					rs.getString("nacionalidad"), rs.getString("e_mail"));
		}
		rs.close();
		return client;
	}

	public static void updateCliente(Cliente cliente,Connection con) throws ClassNotFoundException, SQLException, IOException {
		Cliente client = findByTipoDocAndNumDoc(cliente.getTipoDoc(), cliente.getNumDoc(),con);

	//	Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("update Cliente SET nombre=?, apellido=? ,tipoDoc=? ,"
				+ "numDoc=? ,telFijo=? ,telCel=? ,direccion=? ,ciudad=? ,provincia=? ,nacionalidad=? ,e_mail=? "
				+ " where clienteId=?");

		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setString(3, cliente.getTipoDoc());
		ps.setInt(4, cliente.getNumDoc());
		ps.setInt(5, cliente.getTelFijo());
		ps.setInt(6, cliente.getTelCel());
		ps.setString(7, cliente.getDireccion());
		ps.setString(8, cliente.getCiudad());
		ps.setString(9, cliente.getProvincia());
		ps.setString(10, cliente.getNacionalidad());
		ps.setString(11, cliente.getE_mail());
		ps.setLong(12, client.getClienteId());
		ps.execute();
	}

	public static void deleteCliente(Long id,Connection con) throws ClassNotFoundException, SQLException, IOException {
		//Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Cliente  where clienteId=?");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Cliente> getAllClientes(Connection con) throws ClassNotFoundException, SQLException, IOException {
		//Connection con = Conexion.getConexion();
		List<Cliente> clientes = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Cliente");
		ResultSet rs = ps.executeQuery();
		Cliente client;

		while (rs.next()) {
			client = new Cliente(rs.getLong("clienteId"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("tipoDoc"), rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"),
					rs.getString("direccion"), rs.getString("ciudad"), rs.getString("provincia"),
					rs.getString("nacionalidad"), rs.getString("e_mail"));
			clientes.add(client);
		}
		rs.close();
		return clientes;
	}

}