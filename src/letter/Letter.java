package letter;

import city.Inhabitant;
import content.Content;

public abstract class Letter<C extends Content> {

	/*
	 * Attributes
	 */
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected C content;
	protected Boolean opened;

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
	public Boolean getOpened() {
		return opened;
	}

	/**
	 * Sets a new value to the attribute opened.
	 * 
	 * @param opened
	 *            the opened to set
	 */
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	/**
	 * Returns the letter's cost.
	 * 
	 * @return the cost
	 */
	public abstract double getCost();

	/**
	 * Executes an action on the opening.
	 */
	public void doAction(){
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
	
}
