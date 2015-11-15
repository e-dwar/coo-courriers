package city;

import java.util.ArrayList;
import letter.Letter;

public class City {

	/*
	 * Attributes
	 */
	protected String name;
	protected ArrayList<Letter<?>> postBox;
	protected ArrayList<Inhabitant> inhabitants;

	/*
	 * Constructor
	 */
	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
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
	 * @param name the name to set
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
	 * @param index the position in the list
	 * @return the inhabitant
	 */
	public Inhabitant getInhabitant(int index) {
		return this.inhabitants.get(index);
	}

	/**
	 * Returns the list of the inhabitant of the current city.
	 * 
	 * @return inhabitants
	 */
	public ArrayList<Inhabitant> getInhabitants() {
		return this.inhabitants;
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
		postBox.add(letter);
	}

	/**
	 * Distributes all the letters contained in the postBox.
	 */
	public void distributeLetters() {
		ArrayList<Letter<?>> round = postBox;
		postBox = new ArrayList<Letter<?>>();
		for (Letter<?> letter : round) {
			letter.getReceiver().receiveLetter(letter);
		}
	}

}
