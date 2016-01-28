package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Empleado;

public class EmpleadoService {

	public static void createEmpleado(Empleado empleado, Connection con)
			throws ClassNotFoundException, SQLException, IOException {

		PreparedStatement ps = con
				.prepareStatement("insert into Empleado(nombre, apellido ,tipoDoc ,numDoc ,telFijo ,telCel ,direccion "
						+ ",ciudad ,provincia ,nacionalidad ,e_mail,foto,fechaIngreso ) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
		ps.setString(13, empleado.getFechaIngreso());
		ps.execute();
	}

	public static Empleado findByTipoDocAndNumDoc(String tipoDoc, int numDoc, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Empleado WHERE tipoDoc = ? and numDoc =? and empleadoId > 1");
		ps.setString(1, tipoDoc);
		ps.setInt(2, numDoc);

		ResultSet rs = ps.executeQuery();
		Empleado client = null;

		if (rs.next()) {
			client = new Empleado(rs.getLong("empleadoId"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("tipoDoc"), rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"),
					rs.getString("direccion"), rs.getString("ciudad"), rs.getString("provincia"),
					rs.getString("nacionalidad"), rs.getString("e_mail"), rs.getString("foto"), rs.getString("fechaIngreso"));
		}
		rs.close();
		return client;
	}

	public static void updateEmpleado(Empleado empleado, Connection con)
			throws ClassNotFoundException, SQLException, IOException {
		Empleado empl = findByTipoDocAndNumDoc(empleado.getTipoDoc(), empleado.getNumDoc(), con);

		PreparedStatement ps = con.prepareStatement("update Empleado SET nombre=?, apellido=? ,tipoDoc=? ,"
				+ "numDoc=? ,telFijo=? ,telCel=? ,direccion=? ,ciudad=? ,provincia=? ,nacionalidad=? ,e_mail=? ,"
				+ "foto=?,fechaIngreso=? " + " where empleadoId=? and empleadoId > 1");
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
		ps.setString(13, empleado.getFechaIngreso());
		ps.setLong(14, empl.getEmpleadoId());
		ps.execute();
	}

	public static void deleteEmpleado(Long id, Connection con)
			throws ClassNotFoundException, SQLException, IOException {

		PreparedStatement ps = con.prepareStatement("DELETE FROM Empleado where empleadoId=? and empleadoId > 1");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Empleado> getAllEmpleados(Connection con)
			throws ClassNotFoundException, SQLException, IOException {

		List<Empleado> empleados = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Empleado where empleadoId > 1 ");
		ResultSet rs = ps.executeQuery();
		Empleado empleado;

		while (rs.next()) {
			empleado = new Empleado(rs.getLong("empleadoId"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("tipoDoc"), rs.getInt("numDoc"), rs.getInt("telFijo"), rs.getInt("telCel"),
					rs.getString("direccion"), rs.getString("ciudad"), rs.getString("provincia"),
					rs.getString("nacionalidad"), rs.getString("e_mail"), rs.getString("foto"), rs.getString("fechaIngreso"));
			empleados.add(empleado);
		}
		rs.close();
		return empleados;
	}

}