package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testDefaultConstructor() {
		BankAccount b = new BankAccount();
		
		assertEquals("AccountNo field should be initialised to an empty string", "", b.getAccountNo());
		assertEquals("Balance field should be initialised to 0", 0, b.getBalance());
	}
	
	@Test
	public void testDefaultConstructorTwo() {
		BankAccount b = new BankAccount();
		b.setAccountNo("new account");
		
		assertEquals("AccountNo field should be initialised to 'new account'", "new account", b.getAccountNo());
		assertEquals("Balance field should be initialised to 0", 0, b.getBalance());
	}
	
	@Test
	public void testGetBalance() {
		BankAccount b = new BankAccount();
		b.deposit(50);
		
		assertEquals("Balance value should equal 50", 50, b.getBalance());
	}
	
	@Test
	public void testDepositMethod() {
		BankAccount b = new BankAccount();
		BankAccount c = new BankAccount();
		b.deposit(80);
		c.deposit(10);
		c.deposit(100);
		c.deposit(40);

		assertEquals("Balance value should be updated to 80", 80, b.getBalance());
		assertEquals("Balance value should be updated to 150", 150, c.getBalance());
	}
	
	@Test
	public void testWithdrawMethod() {
		BankAccount b = new BankAccount();
		b.deposit(100);
		b.withdraw(50);
		assertEquals("Balance value after withdrawel has been made should be 50", 50, b.getBalance());
	}
	
	@Test
	public void testInsufficientFunds() {
		BankAccount b = new BankAccount();
		b.deposit(50);
		b.withdraw(100);
		assertEquals("Balance value should not change if there are insufficient funds in the account", 50, b.getBalance());
	}
	
	@Test
	public void testAccountCreation() {
		BankAccount b = new BankAccount();
		BankAccount c = new BankAccount();
		
		assertEquals("Number of BankAccount objects should equal 1", 1, b.getNumberOfAccounts());
		assertEquals("Number of BankAccount objects should equal 2", 2, c.getNumberOfAccounts());
	}
	
	@Test
	public void testToString() {
		BankAccount b = new BankAccount("jdl0001");
		b.deposit(50);
		String toStr = b.toString();
		
		assertTrue("The toString method should be in the standard convention format", 
				toStr.startsWith("BankAccount:[") && 
				toStr.contains("=" + b.getAccountNo() + ", ") &&
				toStr.endsWith("=" + b.getBalance() + ", " + "]"));

	}
}
