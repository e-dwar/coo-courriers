package city;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import letter.Letter;

public class City {

	/*
	 * Attributes
	 */
	protected String name;
	protected CopyOnWriteArrayList<Letter<?>> postBox;
	protected ArrayList<Inhabitant> inhabitants;

	/*
	 * Constructor
	 */
	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
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
	 * Adds an inhabitant to the city.
	 * 
	 * @param inhabitant
	 */
	public void addInhabitant(Inhabitant inhabitant) {
		if (inhabitant.getCity() == null) {
			inhabitant.setCity(this);
			inhabitants.add(inhabitant);
		}
	}

	/**
	 * Returns the inhabitant at the specified position in this list.
	 * 
	 * @param i
	 *            the position in the list
	 * @return the inhabitant
	 */
	public Inhabitant getInhabitant(int i) {
		return this.inhabitants.get(i);
	}

	/**
	 * Returns the number of inhabitants in the city.
	 * 
	 * @return the number of inhabitants in the city
	 */
	public int size() {
		return this.inhabitants.size();
	}

	/**
	 * Adds a letter into the postBox.
	 * 
	 * @param letter
	 */
	protected void addLetter(Letter<?> letter) {
		if (!postBox.contains(letter)) {
			System.out.println("-> " + letter.getSender().getName() + " mails to " + letter.getReceiver().getName());
			System.out.println("- " + letter.getCost() + " are debited from " + letter.getSender().getName() + " account whose balance is now " + letter.getSender().getBankAccount().getAmount());
			postBox.add(letter);

		}
	}

	/**
	 * Distributes all the letters contained in the postBox.
	 */
	public void distributeLetters() {
		if (!postBox.isEmpty()) {
			for (Letter<?> letterTemp : this.postBox) {
				letterTemp.getReceiver().receiveLetter(letterTemp);
				System.out.println("<- " + letterTemp.getSender().getName() + " receives a letter from " + letterTemp.getReceiver().getName());
				System.out.println("- Sender account = " + letterTemp.getSender().getBankAccount().getAmount());
				System.out.println("- Receiver account = " + letterTemp.getReceiver().getBankAccount().getAmount() + "\n\n\n");
			}
		}
	}

}
