package lib;

public class BankAccount {
	//fields
	private String accountNo;
	private int balance;
    static int instanceCounter = 0;
    int counter = 0;
	
	//constructors
	public BankAccount() {
		accountNo = "";
		balance = 0;
        instanceCounter++;
        counter = instanceCounter;
	}
	
	public BankAccount(String accountNo) {
		this.accountNo = accountNo;
		balance = 0;
        instanceCounter++;
        counter = instanceCounter;
	}
	
	//methods
	public void setAccountNo(String accountNo) {
		
		this.accountNo = accountNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int value) {
		balance += value;
	}
	
	public void withdraw(int value) {
		if (value <= balance) {
			balance -= value;
		}
	}
	
	public int getNumberOfAccounts() {
		return counter;
	}
	
	@Override
	public String toString() {
		return "BankAccount:[" + "accountNo" + "=" + accountNo + ", "
				+ "balance" + "=" + balance + "]";
	}
}
