package city;

public class BankAccount {
	
	/*
	 * Attributes
	 */
	protected double amount;

	/*
	 * Constructor
	 */
	public BankAccount(double amount) {
		this.amount = amount;
	}

	
	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute amount.
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Adds money of the account.
	 * @param money
	 */
	public void credit(double money){
		this.amount += money; 
	}
	
	/**
	 * Withdraws money from the account.
	 * @param money
	 */
	public void debit(double money){
		this.amount -= money;
	}
}
