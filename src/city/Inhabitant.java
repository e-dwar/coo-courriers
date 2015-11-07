package city;

import letters.Letter;

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
	public Inhabitant(String name, City city, BankAccount bankAccount) {
		this.name = name;
		this.city = city;
		this.bankAccount = bankAccount;
	}

	/*
	 * Methods
	 */
	
	/**
	 * Returns the value of the attribute name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the value of the attribute city.
	 * @return the city
	 */
	public City getCity() {
		return city;
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
	 */
	public void sendLetter(Letter<?> letter){
		
	}
	
	/**
	 * Executes the action of the received letter.
	 * @param letter
	 */
	public void receiveLetter(Letter<?> letter){
		
	}

}