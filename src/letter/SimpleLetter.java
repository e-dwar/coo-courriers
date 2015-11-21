package letter;

import city.Inhabitant;
import content.Text;

public class SimpleLetter extends Letter<Text> {

	public final static double COST = 1;
	
	/*
	 * Constructor
	 */

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}

	/*
	 * Methods
	 */

	@Override
	public double getCost() {
		return SimpleLetter.COST;
	}

	@Override
	public void doAction() {
		super.doAction();
	}

	/**
	 * @return the type of the letter
	 */
	public String toString() {
		return "simple letter whose content is a " + this.content.toString();
	}
}
