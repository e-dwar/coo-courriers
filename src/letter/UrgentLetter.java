package letter;

public class UrgentLetter<L extends Letter<?>> extends LetterDecorator<L> {

	/*
	 * Constructor
	 */
	public UrgentLetter(L letter) {
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
		return this.content.getCost() * 2;
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
	public String toString() {
		return this.content + " urgent letter";
	}
}
