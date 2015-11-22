package letter;

import city.Inhabitant;
import content.Text;

public class SimpleLetter extends Letter<Text> {

	//COST stands for the cost of a letter
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
	public String getDescription() {
		return "a simple letter";
	}
}
