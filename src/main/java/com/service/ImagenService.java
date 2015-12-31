package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Conexion;
import com.model.Imagen;

public class ImagenService {

	public static void createImagen(Imagen imagen) throws ClassNotFoundException, SQLException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("insert into Imagen(nombre,path,inmuebleId) values(?,?,?)");

		ps.setString(1, imagen.getNombre());
		ps.setString(2, imagen.getPath());
		ps.setLong(3, imagen.getInmuebleId());
		ps.execute();
	}

	public static Imagen findByNombre(String nombre) throws SQLException, ClassNotFoundException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM imagen WHERE nombre = ?");

		ps.setString(1, nombre);

		ResultSet rs = ps.executeQuery();
		Imagen acc = null;

		if (rs.next()) {
			acc = new Imagen(rs.getLong("imagenId"), rs.getString("nombre"), rs.getString("path"),rs.getLong("inmuebleId"));
		}
		rs.close();
		return acc;
	}

	public static void updateImagen(String nombre , Imagen imagen) throws ClassNotFoundException, SQLException, IOException {

		Long imagenId = findByNombre(nombre).getImagenId();
		
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("update imagen SET nombre=?,path=?,inmuebleId=? where imagenId=?");
		ps.setString(1, imagen.getNombre());
		ps.setString(2, imagen.getPath());
		ps.setLong(3, imagen.getInmuebleId());
		ps.setLong(4,imagenId);
		ps.execute();
	}

	public static void deleteImagen(Long id) throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("DELETE FROM imagen  where imagenId=?");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Imagen> getAllImagenes() throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		List<Imagen> imagens = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Imagen");
		ResultSet rs = ps.executeQuery();
		Imagen img;

		while (rs.next()) {
			img = new Imagen(rs.getLong("imagenId"), rs.getString("nombre"), rs.getString("path"),rs.getLong("inmuebleId"));
			imagens.add(img);
		}
		rs.close();
		return imagens;
	}

}