package letter;

public abstract class LetterDecorator<L extends Letter<?>> extends Letter<L> {
	
	/*
	 * Constructor
	 */
	public LetterDecorator(L aLetter) {
		super(aLetter.getSender(), aLetter.getReceiver(), aLetter);
		if (aLetter.isUrgent()) {
			throw new MalformedLetterException("An urgent letter can't be decorated.");
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
		return this.content.getOpened();
	}

	@Override
	public boolean isUrgent() {
		return this.content.isUrgent();
	}
	
	@Override
	public boolean isRegistered(){
		return this.content.isRegistered();
	}
	
	@Override
	public boolean isPromissoryNote(){
		return this.content.isPromissoryNote();
	}
}
