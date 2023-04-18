package simpleBanking;

public class BankAccount {
	private double balance;
	private int accountNumber;
	private static int LAST_ACCOUNT_NUMBER = 0;
	private String accountHolder;
	
	public BankAccount(String ac) {
		this(ac, 0.00);
	}
	
	public BankAccount(String accountHolder, double d) {
		if(d < 0.0) {
			throw new IllegalArgumentException();
		}
		if(accountHolder == null || accountHolder.equals("")) {
			throw new IllegalArgumentException();
		}
		this.balance = d;
		this.accountHolder = accountHolder;
		this.accountNumber = BankAccount.LAST_ACCOUNT_NUMBER + 1;
		BankAccount.LAST_ACCOUNT_NUMBER = this.accountNumber;
	}
	
	// ***** Methods ********************************************
	boolean deposit(double toDeposit) {
		if(toDeposit <= 0) {
			return false;
		}
		balance = toDeposit + balance;
		return true;
	}
	
	boolean withdrawl(double ammount) {
		if(ammount <= 0) {
			return false;
		}
		if(ammount > balance) {
			return false;
		}
		balance = balance - ammount;
		return true;
	}
	
	// ***** Getters *********************************************
	int getAccountNumber() {
		return this.accountNumber;
	}
	
	double getAccountBalance() {
		return this.balance;
	}
	
	String getAccountHolder() {
		return this.accountHolder;
	}
}
