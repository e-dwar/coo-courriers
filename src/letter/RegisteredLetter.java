package letter;

import content.Text;

public class RegisteredLetter<L extends Letter<?>> extends LetterDecorator<L> {

	/*
	 * Constructor
	 */
	public RegisteredLetter(L letter) {
		super(letter);
	}

	/*
	 * Methods
	 */

	/**
	 * @return the cost of a simpleLetter plus 15 cents(for the Acknowledgment
	 *         of receipt)
	 */
	@Override
	public double getCost() {
		return this.content.getCost() + 0.15;
	}

	/**
	 * Opens the letter. Next, the receiver send back the Acknowledgment of
	 * receipt
	 */
	@Override
	public void doAction() {
		this.content.doAction();
		Text aText = new Text("I've well received your letter.");
		Letter<?> letter = new AcknowledgmentOfReceipt(this.receiver, this.sender, aText);
		letter.getSender().sendLetter(letter);
	}

	/**
	 * @return the type of the letter
	 */
	public String toString() {
		return this.content + " registered letter";
	}

}
