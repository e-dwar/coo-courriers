package letter;

import content.Content;

public abstract class LetterDecorator<L extends Letter<?>> extends Letter<Content> {

	protected L content;
	
	/*
	 * Constructor
	 */
	public LetterDecorator(L aLetter) {
		super(aLetter.getSender(), aLetter.getReceiver(), aLetter.getContent());
		content = aLetter;
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
		return this.content.getOpened();
	}

	@Override
	public boolean isUrgent() {
		return this.content.isUrgent() || false;
	}

}
