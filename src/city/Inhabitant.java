package city;

import out.Messages;
import out.TraceBuffer;
import letter.Letter;

public class Inhabitant {

	/*
	 * Attributes
	 */
	protected String name;
	protected City city;
	protected BankAccount bankAccount;

	/*
	 * Constructor
	 */
	public Inhabitant(String name, BankAccount bankAccount) {
		this.name = name;
		this.bankAccount = bankAccount;
	}

	public Inhabitant(String name, City city, BankAccount bankAccount) {
		this(name, bankAccount);
		this.setCity(city);
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the value of the attribute city.
	 * 
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Sets a new value to the attribute city.
	 * 
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * Returns the value of the attribute bankAccount.
	 * @return the bankAccount
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/**
	 * Adds a letter to the postBox contained in the attribute city.
	 * @param letter
	 * @return true if the letter is sent otherwise returns flase
	 */
	public boolean sendLetter(Letter<?> letter) {
		boolean isValid = checkLetter(letter);
		if (isValid) {
			this.bankAccount.debit(letter.getCost());
			this.city.addLetter(letter);
			TraceBuffer.add(Messages.letterSent(letter));
			TraceBuffer.add(Messages.senderDebited(letter));
		}
		return isValid;
	}

	public boolean checkLetter(Letter<?> letter) {
		return letter.getCost() <= this.bankAccount.getAmount();
	}

	/**
	 * Executes the action of the received letter.
	 * 
	 * @param letter
	 */
	public void receiveLetter(Letter<?> letter) {
		TraceBuffer.add(Messages.letterReceived(letter));
		letter.doAction();
	}

	/**
	 * Returns the inhabitant's name(used for the Messages and the TraceBuffer)
	 * @return name
	 */
	public String toString() {
		return this.name;
	}

}
