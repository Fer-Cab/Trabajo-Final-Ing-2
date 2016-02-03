package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.model.Contrato;

public class ContratoService {
	
	
	public static void createContratoAlquiler(Contrato contrato, Connection con) throws ClassNotFoundException, SQLException, IOException {
	
		PreparedStatement ps = con.prepareStatement("insert into ContratoAlquiler(clienteId, inmuebleId,fecha,estado,monto ) values(?,?,?,?,?)");
	
		ps.setLong(1, contrato.getCliente().getClienteId());
		ps.setLong(2, contrato.getInmueble().getInmuebleId());
		ps.setString(3, contrato.getFecha());
		ps.setString(4, contrato.getEstado());
		ps.setDouble(5, contrato.getMonto());
		ps.execute();
	}

	public static void createContratoVenta (Contrato contrato, Connection con) throws ClassNotFoundException, SQLException, IOException {
		
		PreparedStatement ps = con.prepareStatement("insert into ContratoVenta(clienteId, inmuebleId,fecha,monto ) values(?,?,?,?)");
	
		ps.setLong(1, contrato.getCliente().getClienteId());
		ps.setLong(2, contrato.getInmueble().getInmuebleId());
		ps.setString(3, contrato.getFecha());
		ps.setDouble(4, contrato.getMonto());
		ps.execute();
	}
	
	public static List<Contrato> findByClient(String tipoDoc, int numDoc, Connection con) throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Contrato,cliente, inmueble WHERE contrato.clienteId = ? and"
				+ "inmueble.inmuebleId = contrato.inmuebleId and cliente.clienteId = contrato.clienteId");
/*				promoValida = 	new PromoValida(rs.getInt("idpromoValida"),
							  	new Calzado(rs.getInt("codigo"), rs.getString("marca"),
									rs.getString("modelo"), rs.getString("color"),
									rs.getInt("talle")), 
								new Promocion(
									rs.getInt("idPromo"), rs.getString("descripcion"),
									rs.getInt("numeroMaximoItems")));

				promosValidas.add(promoValida);*/
		ps.setLong(1, ClienteService.findByTipoDocAndNumDoc(tipoDoc, numDoc, con).getClienteId());

		ResultSet rs = ps.executeQuery();
		Contrato acc = null;

		if (rs.next()) {
			acc = new Contrato(rs.getLong("ContratoId"),rs.getString("userName"), rs.getString("password"), rs.getString("permisos"));
		}
		rs.close();
		return acc;
	}

	public static void updateContrato(Contrato Contrato, Connection con) throws ClassNotFoundException, SQLException, IOException {
		
		Contrato acc = findByUserName(Contrato.getUserName(),con);
	
		PreparedStatement ps = con
				.prepareStatement("update Contrato SET userName=?,password=?,permisos=? where ContratoId=? and ContratoId > 1");
		ps.setString(1, Contrato.getUserName());
		ps.setString(2, Contrato.getPassword());
		ps.setString(3, Contrato.getPermisos());
		ps.setLong(4, acc.getContratoId());
		ps.execute();
	}

	public static void deleteContrato(Long id, Connection con) throws ClassNotFoundException, SQLException, IOException {
		if(id > 1){
		PreparedStatement ps = con.prepareStatement("DELETE FROM Contrato  where ContratoId=? and ContratoId > 1");
		ps.setLong(1, id);
		ps.execute();}
		else throw new SQLException("you do not have permission to do that");
	}

	public List<Contrato> getAllContratos(Connection con) throws ClassNotFoundException, SQLException, IOException {
		
		List<Contrato> Contratos = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Contrato where ContratoId > 1");
		ResultSet rs = ps.executeQuery();
		Contrato acc;

		while (rs.next()) {
			acc = new Contrato(rs.getLong("ContratoId"),rs.getString("userName"), rs.getString("password"), rs.getString("permisos"));
			Contratos.add(acc);
		}
		rs.close();
		return Contratos;
	}

	public static boolean existUserName(String userName, Connection con) throws ClassNotFoundException, SQLException, IOException {
		boolean exist = false;
		Contrato Contrato = findByUserName(userName,con);
		if (Contrato != null && Contrato.equals(userName)) {
			exist = true;
		}
		return exist;
	}

	public static boolean userExist(Contrato Contrato, Connection con) throws ClassNotFoundException, SQLException, IOException {
		boolean exist = false;
		Contrato findContrato = findByUserName(Contrato.getUserName(),con);
		if (findContrato != null && Contrato.equals(findContrato)) {
			exist = true;
		}
		return exist;
	}

	public static boolean canLog (String name , String pass, Connection con) throws ClassNotFoundException, SQLException, IOException{
		boolean can = false;
	if (existUserName(name, con)){
		Contrato Contrato = findByUserName(name,con);
		if(userExist( Contrato,  con)){
			can = true;
		}
	}	
		return can ;
	}
	
}

