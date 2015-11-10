package city;

import java.util.concurrent.CopyOnWriteArrayList;

import letters.Letter;

public class City {

	/*
	 * Attributes
	 */
	protected String name;
	protected CopyOnWriteArrayList<Letter<?>> postBox;

	/*
	 * Constructor
	 */
	public City(String name) {
		this.name = name;
		postBox = new CopyOnWriteArrayList<Letter<?>>();
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute name.
	 * 
	 * @return name : String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a new value to the attribute name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns a list of Letter contained in the postBox.
	 * 
	 * @return the postBox
	 */
	public CopyOnWriteArrayList<Letter<?>> getPostBox() {
		return postBox;
	}

	/**
	 * Adds a letter into the postBox.
	 * 
	 * @param letter
	 */
	protected void addLetter(Letter<?> letter) {
		if (!postBox.contains(letter)){
			System.out.println("-> " + letter.getSender().getName() + " mails to " + letter.getReceiver().getName());
			System.out.println("- " + letter.getCost() + " are debited from " + letter.getSender().getName() + " account whose balance is now " + letter.getSender().getBankAccount().getAmount());
			postBox.add(letter);
			
		}
	}

	/**
	 * Distributes all the letters contained in the postBox.
	 */
	public void distributeLetters() {
		if(!postBox.isEmpty()){
			for(Letter<?> letterTemp : this.postBox){
				letterTemp.getReceiver().receiveLetter(letterTemp);
				System.out.println("<- " + letterTemp.getSender().getName() + " receives a letter from " + letterTemp.getReceiver().getName());
				System.out.println("- Sender account = " + letterTemp.getSender().getBankAccount().getAmount());
				System.out.println("- Receiver account = " + letterTemp.getReceiver().getBankAccount().getAmount() + "\n\n\n");
			}
		}
	}

}
