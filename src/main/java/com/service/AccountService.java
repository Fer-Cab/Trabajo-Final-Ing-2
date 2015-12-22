package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Conexion;
import com.model.Account;

public class AccountService {

	public static void createAccount(Account account) throws ClassNotFoundException, SQLException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("insert into account(userName,password,permisos) values(?,?,?)");
	
		ps.setString(1, account.getUserName());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getPermisos());
		ps.execute();
	}

	public static Account findByUserName(String userName) throws SQLException, ClassNotFoundException, IOException {

		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM account WHERE userName = ?");
		ps.setString(1, userName);

		ResultSet rs = ps.executeQuery();
		Account acc = null;

		if (rs.next()) {
			acc = new Account(rs.getLong("accountId"),rs.getString("userName"), rs.getString("password"), rs.getString("permisos"));
		}
		rs.close();
		return acc;
	}

	public static void updateAccount(Account account) throws ClassNotFoundException, SQLException, IOException {
		
		Account acc = findByUserName(account.getUserName());
	
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con
				.prepareStatement("update account SET userName=?,password=?,permisos=? where accountId=?");
		ps.setString(1, account.getUserName());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getPermisos());
		ps.setLong(4, acc.getAccountId());
		ps.execute();
	}

	public static void deleteAccount(Long id) throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement("DELETE FROM account  where accountId=?");
		ps.setLong(1, id);
		ps.execute();
	}

	public static List<Account> getAllAccounts() throws ClassNotFoundException, SQLException, IOException {
		Connection con = Conexion.getConexion();
		List<Account> accounts = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Account");
		ResultSet rs = ps.executeQuery();
		Account acc;

		while (rs.next()) {
			acc = new Account(rs.getLong("accountId"),rs.getString("userName"), rs.getString("password"), rs.getString("permisos"));
			accounts.add(acc);
		}
		rs.close();
		return accounts;
	}

	public static boolean existUserName(String userName) throws ClassNotFoundException, SQLException, IOException {
		boolean exist = false;
		Account account = findByUserName(userName);
		if (account != null && account.equals(userName)) {
			exist = true;
		}
		return exist;
	}

	public static boolean userExist(Account account) throws ClassNotFoundException, SQLException, IOException {
		boolean exist = false;
		Account findAccount = findByUserName(account.getUserName());
		if (findAccount != null && account.equals(findAccount)) {
			exist = true;
		}
		return exist;
	}

}