package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Conexion;
import com.model.Propietario;

public class PropietarioService {

	public static void createPropietario(Propietario propietario)
			throws ClassNotFoundException, SQLException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con
				.prepareStatement("insert into Propietario(nombre, apellido ,tipoDoc ,numDoc ,telFijo ,telCel "
						+ ",direccion ,ciudad ,provincia ,nacionalidad ,e_mail,numCuenta ) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, propietario.getNombre());
		ps.setString(2, propietario.getApellido());
		ps.setString(3, propietario.getTipoDoc());
		ps.setInt(4, propietario.getNumDoc());
		ps.setInt(5, propietario.getTelFijo());
		ps.setInt(6, propietario.getTelCel());
		ps.setString(7, propietario.getDireccion());
		ps.setString(8, propietario.getCiudad());
		ps.setString(9, propietario.getProvincia());
		ps.setString(10, propietario.getNacionalidad());
		ps.setString(11, propietario.getE_mail());
		ps.setString(12, propietario.getNumCuenta());
		ps.execute();
	}

	public static Propietario findByTipoDocAndNumDoc(String tipoDoc, int numDoc)
			throws SQLException, ClassNotFoundException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Propietario WHERE tipoDoc = ? and numDoc =?");
		ps.setString(1, tipoDoc);
		ps.setInt(2, numDoc);

		ResultSet rs = ps.executeQuery();
		Propietario propietario = null;

		if (rs.next()) {
			propietario = new Propietario(rs.getLong("propietarioId"),rs.getString("nombre"), rs.getString("apellido"), rs.getString("tipoDoc"),
					rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"), rs.getString("direccion"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getString("nacionalidad"),
					rs.getString("e_mail"), rs.getString("numCuenta"));
		}
		rs.close();
		return propietario;
	}

	public static void updatePropietario(Propietario propietario)
			throws ClassNotFoundException, SQLException, IOException {
		Propietario prop = findByTipoDocAndNumDoc(propietario.getTipoDoc(), propietario.getNumDoc());
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("update Propietario SET nombre=?, apellido=? ,tipoDoc=? ,"
				+ "numDoc=? ,telFijo=? ,telCel=? ,direccion=? ,ciudad=? ,provincia=? ,nacionalidad=? ,e_mail=?,numCuenta=? "
				+ " where propietarioId=?");
		ps.setString(1, propietario.getNombre());
		ps.setString(2, propietario.getApellido());
		ps.setString(3, propietario.getTipoDoc());
		ps.setInt(4, propietario.getNumDoc());
		ps.setInt(5, propietario.getTelFijo());
		ps.setInt(6, propietario.getTelCel());
		ps.setString(7, propietario.getDireccion());
		ps.setString(8, propietario.getCiudad());
		ps.setString(9, propietario.getProvincia());
		ps.setString(10, propietario.getNacionalidad());
		ps.setString(11, propietario.getE_mail());
		ps.setString(12, propietario.getNumCuenta());
		ps.setLong(13, prop.getPropietarioId());
		ps.execute();
	}

	public static void deletePropietario(Long id) throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Propietario  where propietarioId=?");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Propietario> getAllPropietarios() throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		List<Propietario> propietarios = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Propietario");
		ResultSet rs = ps.executeQuery();
		Propietario propietario;

		while (rs.next()) {
			propietario = new Propietario(rs.getLong("propietarioId"),rs.getString("nombre"), rs.getString("apellido"), rs.getString("tipoDoc"),
					rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"), rs.getString("direccion"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getString("nacionalidad"),
					rs.getString("e_mail"), rs.getString("numCuenta"));
			propietarios.add(propietario);
		}
		rs.close();
		return propietarios;
	}

}