package letters;

import content.Content;

public abstract class LetterDecorator extends Letter<Content> {

	/*
	 * Attributes
	 */
	protected Letter<?> letter;
	protected boolean isValid;

	/*
	 * Constructor
	 */
	public LetterDecorator(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter.getContent());
		this.letter = letter;
		this.isValid = !letter.isUrgent();
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the letter's cost.
	 * 
	 * @return the cost
	 */
	public abstract double getCost();
	
	public boolean isValid() {
		return isValid && this.letter.isValid();
	}

}
