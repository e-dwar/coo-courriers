package letter;

import city.Inhabitant;
import content.Text;

public class SimpleLetter extends Letter<Text> {

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
		return 1;
	}

	@Override
	public void doAction() {
		super.doAction();
	}

	/**
	 * @return the type of the letter
	 */
	public String toString() {
		return "simple letter";
	}
}
