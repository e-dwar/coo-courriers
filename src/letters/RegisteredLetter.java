package letters;

public class RegisteredLetter extends LetterDecorator {

	/*
	 * Constructor
	 */
	public RegisteredLetter(Letter<?> letter) {
		super(letter);
	}

	/*
	 * Methods
	 */
	
	@Override
	public double getCost() {
		return this.letter.getCost() + 0.15;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

}
