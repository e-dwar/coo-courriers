package letter;

public abstract class LetterDecorator<L extends Letter<?>> extends Letter<L> {
	
	/*
	 * Constructor
	 */
	public LetterDecorator(L aLetter) {
		super(aLetter.getSender(), aLetter.getReceiver(), aLetter);
		
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
	
	@Override
	public boolean isRegistered(){
		return this.content.isRegistered() || false;
	}
}
