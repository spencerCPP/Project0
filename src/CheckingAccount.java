/* 	
// AUTHOR: Spencer Barrett
// FILENAME: CheckingAccount.java
// SPECIFICATION: Subclass of BankAccount; represents a checking account that overloads BankAccounts's deposit, withdraw, and transfer methods. Overrides BankAccounts's close method
// FOR: CS 1400 - ASSIGNMENT #5
// TIME SPENT: 15 minutes
*/

/**
 * Subclass of BankAccount; CheckingAccount represents a checking account that
 * has a limit on transactions without a fee, has a closing fee, and has a
 * monthly maintenance fee
 * 
 * @author Spencer Barrett
 *
 */
public class CheckingAccount extends BankAccount {

	private int transactionCount; // Field used to hold the amount of transactions
	private final int FREE_TRANSACTIONS = 3; // Constant used to set max free transactions
	private final double TRANSACTION_FEE = 2.0; // Constant used to set transaction fee
	private final double CLOSING_FEE = 5.0; // Constant used to set closing fee
	private final double MAINTENANCE_FEE = 10.0; // Constant used to set maintenance fee

	/**
	 * Constructor for CheckingAccount; Calls BankAccount constructor
	 */
	public CheckingAccount() {
		super(); // Call BankAccount constructor; creates new BankAccount with initial balance: 0
		this.transactionCount = 0; // Initializes transactionCount to 0

	}

	/**
	 * Constructor for CheckingAccount using an initial balance
	 * 
	 * @param initialBalance:double - holds the value of the initial balance
	 */
	public CheckingAccount(double initialBalance) {
		super(initialBalance); // Creates new BankAccount with initial balance using "initialBalance"
		this.transactionCount = 0; // Initializes transactionCount to 0

	}

	/**
	 * Overloaded method from BankAccount; Deposits an inputed amount into an
	 * account; If transactionCount is greater than allotted free transactions (3)
	 * charge a transaction fee (2.0)
	 */
	public void deposit(double amount) {
		this.transactionCount++; // Increment transactionCount

		if (this.transactionCount > FREE_TRANSACTIONS) { // Check if transactionCount exceeded free transactions
			super.withdraw(TRANSACTION_FEE); // Withdraw transaction fee
			super.deposit(amount); // Deposit inputed amount

		} else { // Otherwise...
			super.deposit(amount); // Deposit inputed amount

		}

	}

	/**
	 * Overloaded method from BankAccount; Withdraws an inputed amount from an
	 * account; If transactionCount is greater than allotted free transactions (3)
	 * charge a transaction fee (2.0)
	 */
	public void withdraw(double amount) {
		this.transactionCount++; // Increment transactionCount

		if (this.transactionCount > FREE_TRANSACTIONS) { // Check if transactionCount exceeded free transactions
			super.withdraw(TRANSACTION_FEE); // Withdraw transaction fee
			super.withdraw(amount); // Withdraw inputed amount

		} else { // Otherwise...
			super.withdraw(amount); // Withdraw inputed amount
		}

	}

	/**
	 * Method used to deduct the monthly maintenance fee from an account
	 */
	public void deductMaintenanceFee() {
		super.withdraw(MAINTENANCE_FEE); // Withdraw maintenance fee
		this.transactionCount = 0; // Set transactionCount to 0
	}

	/**
	 * Overridden method of superclass BankAccount; Closes an account, sets
	 * transaction count to 0, charges a closing fee, and transfers balance of
	 * closed account to referenced account
	 *
	 * @param acct:BankAccount - references the account to transfer the balance to
	 */
	@Override
	public void close(BankAccount acct) {
		this.transactionCount = 0; // Set transactionCount to 0
		super.withdraw(CLOSING_FEE); // Withdraw the closing fee
		super.transfer(getBalance(), acct); // Transfer the balance from current account to other referenced account

	}

}
