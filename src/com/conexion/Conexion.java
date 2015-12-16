package com.conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Conexion {

	private static Connection con;

	public static Connection getConexion() throws ClassNotFoundException, SQLException, IOException {
		if (con == null) {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:/C:/Fernando/H2 DataBase/prueba", "Fer", "");
			
		}
		return con;
	}

	
	public void initDb() throws SQLException, IOException, ClassNotFoundException {
	 
		 FileReader file = new FileReader("WebContent/WEB-INF/classes/squema-h2.sql.txt");
	     BufferedReader br = new BufferedReader(file);
	     
	    Connection connection = null;
	    try {
	        connection = getConexion();
	        String line = br.readLine();
	        StringBuilder statement = new StringBuilder();
	        while (line != null) {
	            line = line.trim();
	            if (!line.startsWith("--") && !line.startsWith("#") && !line.startsWith("//")) {
	                statement.append(line);
	                if (line.endsWith(";")) {
	                    executeLine(connection, statement.toString());
	                    statement = new StringBuilder();
	                }
	            }
	            line = br.readLine();
	        }
	        if (statement.length() > 0) {
	            executeLine(connection, statement.toString());
	        }
	    } finally {
	        try {
	            br.close();
	        } catch (Exception e) {;}
	        try {
	            if (connection == null) connection.close();
	        } catch (Exception e) {;}
	    }
	}

	private void executeLine(Connection connection, String statement) throws SQLException {
	    PreparedStatement pstmt = connection.prepareStatement(statement);
	    pstmt.execute();
	    pstmt.close();
	    System.out.println("Ejecutando "+statement);
	}
}
