package letters;

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
	
	@Override
	public double getCost() {
		//Need to be done.
		return 0;
	}

	@Override
	public void doAction() {
		//Need to be done.
	}

}
