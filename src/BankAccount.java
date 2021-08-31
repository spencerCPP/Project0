/* 	
// AUTHOR: Spencer Barrett
// FILENAME: BankAccount.java
// SPECIFICATION: Superclass used to create a bank account, can deposit, withdraw, transfer funds, and contains an abstract method to close an account
// FOR: CS 1400 - ASSIGNMENT #5
// TIME SPENT: 10 minutes
*/

/**
 * Superclass BankAccount represents a base model of a bank account
 * 
 * @author Spencer Barrett
 *
 */
public abstract class BankAccount {

	// balance: double - holds the current balance of the created account
	private double balance;

	/**
	 * Constructor of BankAccount; initiates balance to 0
	 */
	public BankAccount() {
		this.balance = 0; // Initialize balance to 0
	}

	/**
	 * Constructor of BankAccount; creates a BankAccount with an initial balance
	 * 
	 * @param initialBalance:double - holds the inputed initial balance
	 */
	public BankAccount(double initialBalance) {
		this.balance = initialBalance; // Initialize balance to initialBalance

	}

	/**
	 * Method that deposits an amount to balance
	 * 
	 * @param amount:double - holds the inputed amount to deposit
	 */
	public void deposit(double amount) {
		this.balance += amount; // Increment balance by "amount"

	}

	/**
	 * Method that withdraws an amount from balance
	 * 
	 * @param amount:double - holds the inputed amount to withdraw
	 */
	public void withdraw(double amount) {
		this.balance -= amount; // Decrement balance by "amount"

	}

	/**
	 * Getter method for balance:double
	 * 
	 * @return balance:double - the current balance of the BankAccount
	 */
	public double getBalance() {

		return this.balance;
	}

	/**
	 * Method to transfer an amount from one BankAccount to another
	 * 
	 * @param amount:double   - holds the inputed amount to transfer
	 * @param acct:BankAcount - represents the BankAccount to transfer to
	 */
	public void transfer(double amount, BankAccount acct) {
		withdraw(amount); // Call withdraw using "amount" parameter
		acct.deposit(amount); // Using "acct" object, call deposit method using "amount" parameter

	}

	/**
	 * Abstract method used in subclasses to close a BankAccount
	 * 
	 * @param acct:BankAccount - references the BankAccount to close
	 */
	public abstract void close(BankAccount acct);
}
