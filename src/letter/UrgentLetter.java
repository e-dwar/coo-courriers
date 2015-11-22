package letter;

public class UrgentLetter<L extends Letter<?>> extends LetterDecorator<L> {

	//COEFFICIENT stands for the coefficient which is used to determine the final price when the option urgent is chosen.
	public final static double COEFFICIENT = 2;
	
	/*
	 * Constructor
	 */
	public UrgentLetter(L letter) {
		super(letter);
		if (letter.isUrgent()) {
			throw new MalformedLetterException();
		}
	}

	/*
	 * Methods
	 */

	/**
	 * @return Doubles the cost of the letter
	 */
	@Override
	public double getCost() {
		return this.content.getCost() * UrgentLetter.COEFFICIENT;
	}

	@Override
	public boolean isUrgent() {
		return true;
	}

	public void doAction() {
		this.content.doAction();
	}

	/**
	 * @return the type of the letter
	 */
	public String getDescription() {
		return "an urgent letter";
	}
}
