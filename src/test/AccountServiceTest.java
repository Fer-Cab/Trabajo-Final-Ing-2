package test;

import static org.junit.Assert.*;

import java.io.IOException;
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
	Conexion con;

	@Before
	public void initialize() throws ClassNotFoundException, SQLException, IOException {
		ac = new Account("Fer", "pass", "admin");
		ac2 = new Account("Ram", "loq", "admin");
		ac3 = new Account("Fer", "contra", "admin");
		con = new Conexion();

		con.initDb();
	}

	// account con comillas " pasa , corregir

	@Test
	public void createAccountAndFindByUserNameTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac);
		assertEquals("Account [ userName=Fer, password=pass, permisos=admin]",
				AccountService.findByUserName("Fer").toString());
	}

	@Test
	public void getAllAccountsTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac);
		AccountService.createAccount(ac2);
		assertEquals(
				"[Account [ userName=Fer, password=pass, permisos=admin], Account [ userName=Ram, password=loq, permisos=admin]]",
				AccountService.getAllAccounts().toString());
	}

	@Test
	public void updateAccountTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac);
		AccountService.updateAccount(ac3);
		assertEquals("Account [ userName=Fer, password=contra, permisos=admin]",
				AccountService.findByUserName("Fer").toString());
	}

	@Test
	public void deleteAccountTest() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac);
		AccountService.createAccount(ac2);
		AccountService.deleteAccount(2l);
		assertEquals("[Account [ userName=Fer, password=pass, permisos=admin]]",
				AccountService.getAllAccounts().toString());
	}

	@Test
	public void existUserNameTestTrue() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac);
		assertTrue(AccountService.existUserName("Fer"));
	}

	@Test
	public void existUserNameTestFalse() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac2);
		assertFalse(AccountService.existUserName("Fer"));
	}
	
	
	@Test
	public void userExistTestTrue() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac);
		AccountService.createAccount(ac2);
		assertTrue(AccountService.userExist(ac));
	}

	@Test
	public void userExistTestFalse() throws ClassNotFoundException, SQLException, IOException {
		AccountService.createAccount(ac2);
		assertFalse(AccountService.userExist(new Account("Fer", "pass", "admin")));
	}

}