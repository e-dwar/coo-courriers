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
	
	@Override
	public double getCost() {
		return this.letter.getCost() * 2;
	}
	
	@Override
	public boolean isUrgent(){
		return true;
	}

	public void doAction(){
		this.letter.doAction();
	}
	
	public String toString() {
		return "urgent letter";
	}
}
