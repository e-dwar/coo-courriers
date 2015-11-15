package letter;

public class UrgentLetter extends LetterDecorator {

	/*
	 * Constructor
	 */
	public UrgentLetter(Letter<?> letter) {
		super(letter);
	}

	/*
	 * Methods
	 */

	/**
	 * @return Doubles the cost of the letter
	 */
	@Override
	public double getCost() {
		return this.letter.getCost() * 2;
	}

	@Override
	public boolean isUrgent() {
		return true;
	}

	public void doAction() {
		this.letter.doAction();
	}

	/**
	 * @return the type of the letter
	 */
	public String toString() {
		return "urgent letter";
	}
}
