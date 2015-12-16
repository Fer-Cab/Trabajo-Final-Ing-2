package com;

import java.io.IOException;
import java.sql.SQLException;
import com.conexion.Conexion;
import com.model.Imagen;
import com.service.ImagenService;

public class Test {
	public static void main(String[] args) throws IOException {
		
		Imagen img = new Imagen("imagen1", "path1");
		Imagen img2 = new Imagen("imagen2", "path2");
		Imagen img3 = new Imagen("imagen3", "path3");

		try {
			Conexion con = new Conexion();
			con.initDb();

	
			ImagenService.createImagen(img);
		//	ImagenService.createImagen(img2);
			
			ImagenService.updateImagen("imagen1",img2);
			
	//		System.out.println(ImagenService.findByNombre("imagen3").getImagenId());
			
			/* public static void updateImagen(Imagen imagen) throws ClassNotFoundException, SQLException, IOException {

		System.out.println(findByNombre(imagen.getNombre()).getImagenId());
		Long imagenId = findByNombre(imagen.getNombre()).getImagenId();
		
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("update imagen SET nombre=?,path=? where imagenId=?");
		ps.setString(1, imagen.getNombre());
		ps.setString(2, imagen.getPath());
		ps.setLong(3,imagenId);
		ps.execute();
	}				 */
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
