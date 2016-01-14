package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Inmueble;

public class InmuebleService {

	public static void createInmueble(Inmueble inmueble, Connection con)
			throws ClassNotFoundException, SQLException, IOException {

		PreparedStatement ps = con
				.prepareStatement("insert into Inmueble(descripcion, tipoDeInmueble,tipoDeOperacion,"
						+ "estado,direccion,piso,dpto,ciudad, provincia, numHabitaciones,banios,m2,alquiler,venta,tipoSuelo,"
						+ "	garage,ascensor,amueblado,comision) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, inmueble.getDescripcion());
		ps.setString(2, inmueble.getTipoDeInmueble());
		ps.setString(3, inmueble.getTipoDeOperacion());
		ps.setString(4, inmueble.getEstado());
		ps.setString(5, inmueble.getDireccion());
		ps.setString(6, inmueble.getPiso());
		ps.setString(7, inmueble.getDpto());
		ps.setString(8, inmueble.getCiudad());
		ps.setString(9, inmueble.getProvincia());
		ps.setInt(10, inmueble.getNumHabitaciones());
		ps.setInt(11, inmueble.getBanios());
		ps.setInt(12, inmueble.getM2());
		ps.setDouble(13, inmueble.getAlquiler());
		ps.setDouble(14, inmueble.getVenta());
		ps.setString(15, inmueble.getTipoSuelo());
		ps.setBoolean(16, inmueble.isGarage());
		ps.setBoolean(17, inmueble.isAscensor());
		ps.setBoolean(18, inmueble.isAmueblado());
		ps.setDouble(19, inmueble.getComision());
		ps.execute();
	}

	public static Inmueble findByDireccionAndPisoAndDpto(String direccion, String piso, String dpto, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE direccion=? and piso=? and dpto=?");
		ps.setString(1, direccion);
		ps.setString(2, piso);
		ps.setString(3, dpto);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"), 
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

		}
		rs.close();
		return inmueble;
	}

	public static void updateInmueble(Inmueble inmueble, Connection con)
			throws ClassNotFoundException, SQLException, IOException {

		Long inmuebleId = InmuebleService
				.findByDireccionAndPisoAndDpto(inmueble.getDireccion(), inmueble.getPiso(), inmueble.getDpto(), con)
				.getInmuebleId();

		PreparedStatement ps = con.prepareStatement(
				"update Inmueble SET descripcion=?, tipoDeInmueble=?,tipoDeOperacion=?,"
						+ "estado=?,direccion=?,piso=?,dpto=?,ciudad=?, provincia=?,numHabitaciones=?,banios=?,"
						+ "m2=?,alquiler=?,venta=?,tipoSuelo=?,garage=?,ascensor=?,amueblado=?,comision=? where inmuebleId=?");
		ps.setString(1, inmueble.getDescripcion());
		ps.setString(2, inmueble.getTipoDeInmueble());
		ps.setString(3, inmueble.getTipoDeOperacion());
		ps.setString(4, inmueble.getEstado());
		ps.setString(5, inmueble.getDireccion());
		ps.setString(6, inmueble.getPiso());
		ps.setString(7, inmueble.getDpto());
		ps.setString(8, inmueble.getCiudad());
		ps.setString(9, inmueble.getProvincia());
		ps.setInt(10, inmueble.getNumHabitaciones());
		ps.setInt(11, inmueble.getBanios());
		ps.setInt(12, inmueble.getM2());
		ps.setDouble(13, inmueble.getAlquiler());
		ps.setDouble(14, inmueble.getVenta());
		ps.setString(15, inmueble.getTipoSuelo());
		ps.setBoolean(16, inmueble.isGarage());
		ps.setBoolean(17, inmueble.isAscensor());
		ps.setBoolean(18, inmueble.isAmueblado());
		ps.setDouble(19, inmueble.getComision());
		ps.setLong(20, inmuebleId);
		ps.execute();
	}

	public static void deleteInmueble(Long id, Connection con)
			throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM Inmueble where inmuebleId=?");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Inmueble> getAllInmuebles(Connection con)
			throws ClassNotFoundException, SQLException, IOException {
		List<Inmueble> inmuebles = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble");
		ResultSet rs = ps.executeQuery();
		Inmueble inmueble;

		while (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"),
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByTipoDeInmueble(String tipoDeInmueble, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE tipoDeInmueble=?");
		ps.setString(1, tipoDeInmueble);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"),
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByTipoDeOperacion(String tipoDeOperacion, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE tipoDeOperacion=?");
		ps.setString(1, tipoDeOperacion);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"),
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByTipoDeEstado(String tipoDeEstado, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE tipoDeEstado=?");
		ps.setString(1, tipoDeEstado);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"), 
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByCiudad(String ciudad, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE ciudad=?");
		ps.setString(1, ciudad);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"), 
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByNumHabitaciones(int numHabitaciones, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE numHabitaciones=?");
		ps.setInt(1, numHabitaciones);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"),
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByM2(int m2, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE m2=?");
		ps.setInt(1, m2);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"), 
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByAlquiler(double alquiler, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE alquiler=?");
		ps.setDouble(1, alquiler);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"), 
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

	public List<Inmueble> getInmuebleByVenta(double venta, Connection con)
			throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Inmueble WHERE venta=?");
		ps.setDouble(1, venta);

		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		List<Inmueble> inmuebles = new ArrayList<>();

		if (rs.next()) {
			inmueble = new Inmueble(rs.getLong("inmuebleId"), rs.getString("descripcion"),
					rs.getString("tipoDeInmueble"), rs.getString("tipoDeOperacion"),
					rs.getString("estado"), rs.getString("direccion"), rs.getString("piso"), rs.getString("dpto"),
					rs.getString("ciudad"), rs.getString("provincia"), rs.getInt("numHabitaciones"),
					rs.getInt("banios"), rs.getInt("m2"), rs.getDouble("alquiler"), rs.getDouble("venta"),
					rs.getString("tipoSuelo"), rs.getBoolean("garage"), rs.getBoolean("ascensor"),
					rs.getBoolean("amueblado"), rs.getDouble("comision"));

			inmuebles.add(inmueble);
		}
		rs.close();
		return inmuebles;
	}

}
