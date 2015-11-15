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
	
	/**
	 * @return the cost of a simpleLetter plus 15 cents(for the Acknowledgment of receipt)
	 */
	@Override
	public double getCost() {
		return this.letter.getCost() + 0.15;
	}

	/**
	 * Opens the letter. Next, the receiver send back the Acknowledgment of receipt
	 */
	@Override
	public void doAction(){
		this.letter.doAction();
		Text aText = new Text("I've well received your letter.");
		Letter<?> letter = new AcknowledgmentOfReceipt(this.receiver, this.sender, aText);
		letter.getSender().sendLetter(letter);
	}
	
	/**
	 * @return the type of the letter
	 */
	public String toString() {
		return "registered letter";
	}

}
