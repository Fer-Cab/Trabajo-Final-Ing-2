package com;

import java.io.IOException;
import java.sql.SQLException;

import com.conexion.Conexion;
import com.model.Account;
import com.model.Cliente;
import com.service.AccountService;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		Account ac = new Account("Fer", "pass", "admin");
		Cliente client = new Cliente("nombre", "apellido", "tipoDoc",
				1, 1, 1, "direccion", "ciudad", "provincia", "nacionalidad", "e_mail");
		
		try {
			
			Conexion con = new Conexion();
		
			con.initDb();
			
			AccountService.createAccount(ac);
		//	ClienteService.createCliente(client);
			
			System.out.println(AccountService.findByUserName("Fer"));
		//System.out.println(ClienteService.getAllClientes());	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
