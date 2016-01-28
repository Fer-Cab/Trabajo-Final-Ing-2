package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.conexion.Conexion;
//import com.conexion.Conexion;
//import com.model.Cliente;
import com.model.Propietario;
//import com.model.Imagen;
//import com.service.ClienteService;
//import com.service.ImagenService;
import com.service.PropietarioService;

public class Test {
	public static void main(String[] args) throws IOException {

	//	Imagen img = new Imagen("imagen1", "path1");
	//	Imagen img2 = new Imagen("imagen2", "path2");
	//	Imagen img3 = new Imagen("imagen3", "path3");

		try {
			/* Conexion con = new Conexion();
			// con.initDb();

			ImagenService.createImagen(img);
			// ImagenService.createImagen(img2);

			ImagenService.updateImagen("imagen1", img2);

			// System.out.println(ImagenService.findByNombre("imagen3").getImagenId());
			*/
			/*
			 * public static void updateImagen(Imagen imagen) throws
			 * ClassNotFoundException, SQLException, IOException {
			 * 
			 * System.out.println(findByNombre(imagen.getNombre()).getImagenId()
			 * ); Long imagenId =
			 * findByNombre(imagen.getNombre()).getImagenId();
			 * 
			 * Connection con = Conexion.getConexion(); PreparedStatement ps =
			 * con.prepareStatement(
			 * "update imagen SET nombre=?,path=? where imagenId=?");
			 * ps.setString(1, imagen.getNombre()); ps.setString(2,
			 * imagen.getPath()); ps.setLong(3,imagenId); ps.execute(); }
			 */

		/*	Cliente client;
			Cliente client2;
			Cliente client3;
			Connection con = null;

			client = new Cliente("nombre", "apellido", "tipoDoc", 1, 1, 1, "direccion", "ciudad", "provincia",
					"nacionalidad", "e_mail");
			client2 = new Cliente("nombre2", "apellido2", "tipoDoc2", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
					"nacionalidad2", "e_mail2");
			client3 = new Cliente("nombre3", "apellido3", "tipoDoc", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
					"nacionalidad3", "e_mail3");*/

			//con = new Conexion();
			//con.initDb();
/*
			ClienteService.createCliente(client,con);
			ClienteService.createCliente(client2,con);
			
			System.out.println(	ClienteService.getAllClientes(con).toString());
			
			ClienteService.updateCliente(client3, con);
			
			System.out.println(	ClienteService.getAllClientes(con).toString());*/
			

			Propietario prop;
			Propietario prop2;
			Propietario prop3;
			Connection con;
			Conexion con1;

				prop = new Propietario("nombre", "apellido", "DNI", 1, 1, 1, "direccion", "ciudad", "provincia",
						"nacionalidad", "e_mail", "numCuenta");
				prop2 = new Propietario("nombre2", "apellido2", "DNI", 2, 2, 2, "direccion2", "ciudad2", "provincia2",
						"nacionalidad2", "e_mail2", "numCuenta2");
				prop3 = new Propietario("nombre3", "apellido3", "DNI", 1, 3, 3, "direccion3", "ciudad3", "provincia3",
						"nacionalidad3", "e_mail3", "numCuenta3");

				con1 = new Conexion();
				con1.initDb();
				 con = Conexion.getConexion();
				 
			//		PropietarioService.createPropietario(prop,con);
					//System.out.println(PropietarioService.getAllPropietarios(con).toString());
					PropietarioService.createPropietario(prop2,con);
					PropietarioService.createPropietario(prop,con);
					System.out.println(PropietarioService.getAllPropietarios(con).toString());

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
