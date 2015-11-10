package letters;

import content.Text;
import exceptions.NotEnoughMoneyException;

public class RegisteredLetter extends LetterDecorator {

	/*
	 * Constructor
	 */
	public RegisteredLetter(Letter<?> letter) {
		super(letter);
	}
	/*
	 * Methods
	 */
	
	@Override
	public double getCost() {
		return this.letter.getCost() + 0.15;
	}

	@Override
	public void doAction() {
		super.doAction();
		Text aText = new Text("I've well received your letter.");
		Letter<?> letter = new AcknowledgmentOfReceipt(this.receiver, this.sender, aText);
		
		try {
			this.receiver.sendLetter(letter);
		} catch(NotEnoughMoneyException exception){
			System.out.println("Error : " + exception.getMessage());
		}
	}

}
