package letter;

import content.Text;

public class RegisteredLetter<L extends Letter<?>> extends LetterDecorator<L> {

	// EXTRA_COST stands for the the extra cost of the registered letter. Allows
	// the sender to be aware when the receiver receives the letter.
	public final static double EXTRA_COST = 0.15;

	/*
	 * Constructor
	 */
	public RegisteredLetter(L aLetter) {
		super(aLetter);
		if (aLetter.isRegistered()) {
			throw new MalformedLetterException("Can't use registered letter multiple times.");
		}
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
		return this.content.getCost() + EXTRA_COST;
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
	public String getDescription() {
		return "a registered letter";
	}

	@Override
	public boolean isRegistered() {
		return true;
	}
}
