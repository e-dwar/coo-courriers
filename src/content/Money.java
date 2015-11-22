package content;

public class Money implements Content {

	/*
	 * Attributes
	 */
	private double amount;

	/*
	 * Constructor
	 */
	public Money(double amount) {
		this.amount = amount;
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute amount.
	 * 
	 * @return the amount
	 */
	public double getAmount() {
		return this.amount;
	}

	/**
	 * @return a string with the type of the content and with his content.
	 */
	public String toString() {
		return "an amount of money [" + this.amount + "$]";
	}

}
