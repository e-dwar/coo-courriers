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
		return this.letter.getCost() * 2;
	}

	@Override
	public void doAction() {
		//Need to be done.
	}
	
	@Override
	public boolean isUrgent(){
		return true;
	}

}
