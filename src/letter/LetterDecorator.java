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
	public LetterDecorator(Letter<?> aLetter) {
		super(aLetter.getSender(), aLetter.getReceiver(), aLetter.getContent());
		letter = aLetter;
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

	@Override
	public boolean isUrgent() {
		return this.letter.isUrgent() || false;
	}

}
