package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Conexion;
import com.model.Empleado;

public class EmpleadoService {

	public static void createEmpleado(Empleado empleado) throws ClassNotFoundException, SQLException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con
				.prepareStatement("insert into Empleado(nombre, apellido ,tipoDoc ,numDoc ,telFijo ,telCel ,direccion "
						+ ",ciudad ,provincia ,nacionalidad ,e_mail,foto,sector,categoria,fechaIngreso ) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, empleado.getNombre());
		ps.setString(2, empleado.getApellido());
		ps.setString(3, empleado.getTipoDoc());
		ps.setInt(4, empleado.getNumDoc());
		ps.setInt(5, empleado.getTelFijo());
		ps.setInt(6, empleado.getTelCel());
		ps.setString(7, empleado.getDireccion());
		ps.setString(8, empleado.getCiudad());
		ps.setString(9, empleado.getProvincia());
		ps.setString(10, empleado.getNacionalidad());
		ps.setString(11, empleado.getE_mail());
		ps.setString(12, empleado.getFoto());
		ps.setString(13, empleado.getSector());
		ps.setString(14, empleado.getCategoria());
		ps.setString(15, empleado.getFechaIngreso());
		ps.execute();
	}

	public static Empleado findByTipoDocAndNumDoc(String tipoDoc, int numDoc)
			throws SQLException, ClassNotFoundException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Empleado WHERE tipoDoc = ? and numDoc =?");
		ps.setString(1, tipoDoc);
		ps.setInt(2, numDoc);

		ResultSet rs = ps.executeQuery();
		Empleado client = null;

		if (rs.next()) {
			client = new Empleado(rs.getLong("empleadoId"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("tipoDoc"), rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"),
					rs.getString("direccion"), rs.getString("ciudad"), rs.getString("provincia"),
					rs.getString("nacionalidad"), rs.getString("e_mail"), rs.getString("foto"), rs.getString("sector"),
					rs.getString("categoria"), rs.getString("fechaIngreso"));
		}
		rs.close();
		return client;
	}

	public static void updateEmpleado(Empleado empleado) throws ClassNotFoundException, SQLException, IOException {
		Empleado empl = findByTipoDocAndNumDoc(empleado.getTipoDoc(), empleado.getNumDoc());
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("update Empleado SET nombre=?, apellido=? ,tipoDoc=? ,"
				+ "numDoc=? ,telFijo=? ,telCel=? ,direccion=? ,ciudad=? ,provincia=? ,nacionalidad=? ,e_mail=? ,"
				+ "foto=?,sector=?,categoria=?,fechaIngreso=? " + " where empleadoId=?");
		ps.setString(1, empleado.getNombre());
		ps.setString(2, empleado.getApellido());
		ps.setString(3, empleado.getTipoDoc());
		ps.setInt(4, empleado.getNumDoc());
		ps.setInt(5, empleado.getTelFijo());
		ps.setInt(6, empleado.getTelCel());
		ps.setString(7, empleado.getDireccion());
		ps.setString(8, empleado.getCiudad());
		ps.setString(9, empleado.getProvincia());
		ps.setString(10, empleado.getNacionalidad());
		ps.setString(11, empleado.getE_mail());
		ps.setString(12, empleado.getFoto());
		ps.setString(13, empleado.getSector());
		ps.setString(14, empleado.getCategoria());
		ps.setString(15, empleado.getFechaIngreso());
		ps.setLong(16, empl.getEmpleadoId());
		ps.execute();
	}

	public static void deleteEmpleado(Long id) throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Empleado where empleadoId=?");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Empleado> getAllEmpleados() throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		List<Empleado> empleados = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Empleado");
		ResultSet rs = ps.executeQuery();
		Empleado empleado;

		while (rs.next()) {
			empleado = new Empleado(rs.getLong("empleadoId"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("tipoDoc"), rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"),
					rs.getString("direccion"), rs.getString("ciudad"), rs.getString("provincia"),
					rs.getString("nacionalidad"), rs.getString("e_mail"), rs.getString("foto"), rs.getString("sector"),
					rs.getString("categoria"), rs.getString("fechaIngreso"));
			empleados.add(empleado);
		}
		rs.close();
		return empleados;
	}

}