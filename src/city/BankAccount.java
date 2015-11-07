package city;

public class BankAccount {
	
	/*
	 * Attributes
	 */
	protected int amount;

	/*
	 * Constructor
	 */
	public BankAccount(int amount) {
		this.amount = amount;
	}

	
	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute amout.
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Adds money of the account.
	 * @param money
	 */
	public void credit(int money){
		this.amount += money; 
	}
	
	/**
	 * Withdraws money from the account.
	 * @param money
	 */
	public void debit(int money){
		this.amount -= money;
	}
}
