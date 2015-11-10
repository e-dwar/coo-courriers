package letters;

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
		if(!letter.isUrgent()){
			this.letter = letter;
		}
		else {
			throw new IllegalArgumentException("This letter is not well formed.");
		}
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
	
}
