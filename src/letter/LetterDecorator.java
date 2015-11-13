package letter;

import content.Content;

public abstract class LetterDecorator extends Letter<Content> {

	/*
	 * Attributes
	 */
	protected Letter<?> letter;

	/*
	 * Constructor
	 */
	public LetterDecorator(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter.getContent());
		if (!letter.isUrgent()) {
			this.letter = letter;
		} else {
			throw new MalformedLetterException();
		}
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute opened.
	 * 
	 * @return the opened
	 */
	public Boolean getOpened() {
		return this.letter.getOpened();
	}

	/**
	 * Returns the letter's cost.
	 * 
	 * @return the cost
	 */
	public abstract double getCost();

}
