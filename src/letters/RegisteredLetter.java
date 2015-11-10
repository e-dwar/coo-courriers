package letters;

import content.Text;

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
		super.doAction();
		Text aText = new Text("I've well received your letter.");
		Letter<?> letter = new SimpleLetter(this.receiver, this.sender, aText);
		this.receiver.sendLetter(letter);
	}

}
