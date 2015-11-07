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
	public LetterDecorator(Letter<?> letter){
		super(letter.getSender(), letter.getReceiver(), letter.getContent());
		this.letter = letter;
	}

	/*
	 * Methods
	 */
	
	/**
	 * Returns the letter's cost.
	 * @return the cost
	 */
	public abstract double getCost();
	
	
	/**
	 * Executes an action on the opening.
	 */
	public abstract void doAction();
	
}
