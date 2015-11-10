package city;

import java.util.ArrayList;
import letters.Letter;

public class City {

	/*
	 * Attributes
	 */
	protected String name;
	protected ArrayList<Letter<?>> postBox;

	/*
	 * Constructor
	 */
	public City(String name) {
		this.name = name;
		postBox = new ArrayList<Letter<?>>();
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
	public ArrayList<Letter<?>> getPostBox() {
		return postBox;
	}

	/**
	 * Adds a letter into the postBox.
	 * 
	 * @param letter
	 */
	protected void addLetter(Letter<?> letter) {
		if (!postBox.contains(letter))
			postBox.add(letter);
	}

	/**
	 * Distributes all the letters contained in the postBox.
	 */
	public void distributeLetters() {

	}

}
