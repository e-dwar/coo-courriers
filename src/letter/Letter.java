package letter;

import city.BankAccount;
import city.Inhabitant;
import content.Content;

public abstract class Letter<C extends Content> implements Content {

	/*
	 * Attributes
	 */
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected C content;
	protected boolean opened;

	/*
	 * Constructor
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.opened = false;
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the letter's cost.
	 * 
	 * @return the cost
	 */
	public abstract double getCost();

	/**
	 * Returns a description of the letter.
	 * 
	 * @return The description of the letter.s
	 */
	public abstract String getDescription();

	/**
	 * Returns the value of the attribute sender.
	 * 
	 * @return the sender
	 */
	public Inhabitant getSender() {
		return sender;
	}

	/**
	 * Returns the value of the attribute receiver.
	 * 
	 * @return the receiver
	 */
	public Inhabitant getReceiver() {
		return receiver;
	}

	/**
	 * Returns the value of the attribute content.
	 * 
	 * @return the content
	 */
	public C getContent() {
		return content;
	}

	/**
	 * Returns the value of the attribute opened.
	 * 
	 * @return the opened
	 */
	public boolean getOpened() {
		return opened;
	}

	/**
	 * Sets a new value to the attribute opened.
	 * 
	 * @param opened the opened to set
	 */
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	/**
	 * Executes an action on the opening.
	 */
	public void doAction() {
		this.setOpened(true);
	}

	/**
	 * Returns if the letter is urgent or not.
	 * 
	 * @return false
	 */
	public boolean isUrgent() {
		return false;
	}

	/**
	 * Returns if the letter is registered or not.
	 * 
	 * @return false
	 */
	public boolean isRegistered() {
		return false;
	}

	/**
	 * Returns if the letter is a promissory note or not.
	 * 
	 * @return false
	 */
	public boolean isPromissoryNote() {
		return false;
	}

	/**
	 * @param bankAccount
	 * @return true if the letter cost less than the amount on the bankAccount,
	 *         otherwise, returns false
	 */
	public boolean checkLetter(BankAccount bankAccount) {
		return this.getCost() <= bankAccount.getAmount();
	}

	public String toString() {
		return this.getDescription() + " whose content is " + this.content;
	}
}
