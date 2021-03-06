package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Account;

public class AccountService {
	
		public static void createAccount(Account account, Connection con) throws ClassNotFoundException, SQLException, IOException {
	
		PreparedStatement ps = con.prepareStatement("insert into account(userName,password,permisos,empleadoId) values(?,?,?,?)");
	
		ps.setString(1, account.getUserName());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getPermisos());
		ps.setLong(4,EmpleadoService.findByTipoDocAndNumDoc(account.getTipoDoc(),account.getNumDoc(),con).getEmpleadoId());
		ps.execute();
	}

	public static Account findByUserName(String userName, Connection con) throws SQLException, ClassNotFoundException, IOException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM account WHERE userName = ? and accountId > 1");
		ps.setString(1, userName);

		ResultSet rs = ps.executeQuery();
		Account acc = null;

		if (rs.next()) {
			acc = new Account(rs.getLong("accountId"),rs.getString("userName"), rs.getString("password"), rs.getString("permisos"));
		}
		rs.close();
		return acc;
	}

	public static void updateAccount(Account account, Connection con) throws ClassNotFoundException, SQLException, IOException {
		
		Account acc = findByUserName(account.getUserName(),con);
	
		PreparedStatement ps = con
				.prepareStatement("update account SET userName=?,password=?,permisos=? where accountId=? and accountId > 1");
		ps.setString(1, account.getUserName());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getPermisos());
		ps.setLong(4, acc.getAccountId());
		ps.execute();
	}

	public static void deleteAccount(Long id, Connection con) throws ClassNotFoundException, SQLException, IOException {
		if(id > 1){
		PreparedStatement ps = con.prepareStatement("DELETE FROM account  where accountId=? and accountId > 1");
		ps.setLong(1, id);
		ps.execute();}
		else throw new SQLException("you do not have permission to do that");
	}

	public List<Account> getAllAccounts(Connection con) throws ClassNotFoundException, SQLException, IOException {
		
		List<Account> accounts = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Account where accountId > 1");
		ResultSet rs = ps.executeQuery();
		Account acc;

		while (rs.next()) {
			acc = new Account(rs.getLong("accountId"),rs.getString("userName"), rs.getString("password"), rs.getString("permisos"));
			accounts.add(acc);
		}
		rs.close();
		return accounts;
	}

	public static boolean existUserName(String userName, Connection con) throws ClassNotFoundException, SQLException, IOException {
		boolean exist = false;
		Account account = findByUserName(userName,con);
		if (account != null && account.equals(userName)) {
			exist = true;
		}
		return exist;
	}

	public static boolean userExist(Account account, Connection con) throws ClassNotFoundException, SQLException, IOException {
		boolean exist = false;
		Account findAccount = findByUserName(account.getUserName(),con);
		if (findAccount != null && account.equals(findAccount)) {
			exist = true;
		}
		return exist;
	}

	public static boolean canLog (String name , String pass, Connection con) throws ClassNotFoundException, SQLException, IOException{
		boolean can = false;
	if (existUserName(name, con)){
		Account account = findByUserName(name,con);
		if(userExist( account,  con)){
			can = true;
		}
	}	
		return can ;
	}
	
}

