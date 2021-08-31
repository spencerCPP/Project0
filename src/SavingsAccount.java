/* 	
// AUTHOR: Spencer Barrett
// FILENAME: SavingsAccount.java
// SPECIFICATION: Subclass of BankAccount; represents a savings account with a set interest rate; adds interest to balance. Overrides BankAccounts's close method
// FOR: CS 1400 - ASSIGNMENT #5
// TIME SPENT: 10 minutes
*/

/**
 * Subclass of BankAccount; SavingsAccount represents a savings account that has
 * an interest rate used to accrue interest over time
 * 
 * @author Spencer Barrett
 *
 */
public class SavingsAccount extends BankAccount {
	private double interestRate; // Field that holds the interest rate of the savings account

	/**
	 * Constructor for SavingsAccount; calls superclass BankAccount constructor
	 * 
	 * @param rate:double - holds the interest rate of new savings account
	 */
	public SavingsAccount(double rate) {
		super(); // Creates new BankAccount with initial balance: 0
		this.interestRate = rate; // Initializes interestRate to inputed; rate

	}

	/**
	 * Constructor for SavingsAccount; calls superclass BankAccount constructor with
	 * an initial balance
	 * 
	 * @param rate:double           - holds the interest rate of new savings account
	 * @param initialBalance:double - holds the value of the initial balance
	 */
	public SavingsAccount(double rate, double initialBalance) {
		super(initialBalance); // Create new BankAccount with inputed initial balance
		this.interestRate = rate; // Initializes interestRate to inputed; rate
	}

	/**
	 * Method to add the interest on the balance
	 */
	public void addInterest() {
		double interest = ((super.getBalance() * this.interestRate)); // Multiplies the balance by the interest rate
		super.deposit(interest); // Deposits the resulting interest into SavingsAccount

	}

	/**
	 * Overridden method of superclass BankAccount; Closes an account and transfers
	 * the balance from closed account to referenced account
	 * 
	 * @param acct:BankAccount - references the account to transfer the balance to
	 */
	@Override
	public void close(BankAccount acct) {
		super.transfer(getBalance(), acct); // Transfer the balance from current account to other referenced account

	}

}
