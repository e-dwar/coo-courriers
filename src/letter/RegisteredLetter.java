package letter;

import content.Text;

public class RegisteredLetter<L extends Letter<?>> extends LetterDecorator<L> {

	//EXTRA_COST stands for the the extra cost of the registered letter. Allows the sender to be aware when the receiver receives the letter.
	public final static double EXTRA_COST = 0.15;
	
	/*
	 * Constructor
	 */
	public RegisteredLetter(L letter) {
		super(letter);
		if (letter.isRegistered()) {
			throw new MalformedLetterException();
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
		//If we detect an UrgentLetter in our content, we have to change the way that we calculate the final cost.
		if(!this.content.isUrgent())
			return this.content.getCost() + EXTRA_COST;
		else 
			/*Our content has already been multiplied by the UrgentLetter's coefficient. But what we want, is that the multiplication is done at the end.
			 * So, we're dividing the cost to obtain a cost coefficient without and then adds additional cost then multiplied again
			 */
			return (((this.content.getCost())/UrgentLetter.COEFFICIENT) + EXTRA_COST) * UrgentLetter.COEFFICIENT;
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
	public boolean isRegistered(){
		return true;
	}
}
