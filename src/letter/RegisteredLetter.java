package letter;

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
	public void doAction(){
		this.letter.doAction();
		Text aText = new Text("I've well received your letter.");
		Letter<?> letter = new AcknowledgmentOfReceipt(this.receiver, this.sender, aText);
		letter.getSender().sendLetter(letter);
	}
	
	public String toString() {
		return "registered letter";
	}

}
