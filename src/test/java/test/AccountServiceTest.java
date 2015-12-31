package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

import com.conexion.Conexion;
import com.model.Account;
import com.service.AccountService;

public class AccountServiceTest {

	Account ac;
	Account ac2;
	Account ac3;
	AccountService accS;
	
	Conexion con1 ;
	Connection con ;
	

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		ac = new Account("Fer", "pass", "admin");
		ac2 = new Account("Ram", "loq", "admin");
		ac3 = new Account("Fer", "contra", "admin");
		accS = new AccountService();

		con1 = new Conexion();
		con1.initDb();
		 con = Conexion.getConexion();
		
	}

	// account con comillas " pasa , corregir

	@Test
	public void createAccountAndFindByUserNameTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac,con);
		assertEquals("Account [ userName=Fer, password=pass, permisos=admin]",
				AccountService.findByUserName("Fer",con).toString());
	}

	@Test
	public void getAllAccountsTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac,con);
		AccountService.createAccount(ac2,con);
		assertEquals(
				"[Account [ userName=Fer, password=pass, permisos=admin], Account [ userName=Ram, password=loq, permisos=admin]]",
				accS.getAllAccounts(con).toString());
	}

	@Test
	public void updateAccountTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac,con);
		AccountService.updateAccount(ac3,con);
		assertEquals("Account [ userName=Fer, password=contra, permisos=admin]",
				AccountService.findByUserName("Fer",con).toString());
	}

	@Test
	public void deleteAccountTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac,con);
		AccountService.createAccount(ac2,con);
		AccountService.deleteAccount(2l,con);
		assertEquals("[Account [ userName=Fer, password=pass, permisos=admin]]",
				accS.getAllAccounts(con).toString());
	}

	@Test
	public void existUserNameTestTrue() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac,con);
		assertTrue(AccountService.existUserName("Fer",con));
	}

	@Test
	public void existUserNameTestFalse() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac2,con);
		assertFalse(AccountService.existUserName("Fer",con));
	}
	
	
	@Test
	public void userExistTestTrue() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac,con);
		AccountService.createAccount(ac2,con);
		assertTrue(AccountService.userExist(ac,con));
	}

	@Test
	public void userExistTestFalse() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac2,con);
		assertFalse(AccountService.userExist(new Account("Fer", "pass", "admin"),con));
	}

}