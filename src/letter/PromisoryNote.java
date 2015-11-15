package letter;

import city.Inhabitant;
import content.*;

public class PromisoryNote extends Letter<Money> {

	/*
	 * Constructor
	 */
	public PromisoryNote(Inhabitant sender, Inhabitant receiver, Money content) {
		super(sender, receiver, content);
	}

	/*
	 * Methods
	 */

	/**
	 * @return the cost of a simple letter plus 1% of the amount sent.
	 */
	@Override
	public double getCost() {
		return 1 + (this.content.getAmount() * 0.01);

	}

	/**
	 * Opens the letter. Next, transfers money from the sender to the receiver. After that, the receiver send a thankful letter
	 */
	@Override
	public void doAction() {
		super.doAction();
		if(this.content.getAmount() <= this.sender.getBankAccount().getAmount()){
			this.sender.getBankAccount().debit(this.content.getAmount());
			this.receiver.getBankAccount().credit(this.content.getAmount());
			Text aText = new Text("Thanks for the money!");
			Letter<?> letter = new SimpleLetter(this.receiver, this.sender, aText);
			letter.getSender().sendLetter(letter);
		}
	}
	
	/**
	 * @return the type of the letter with his content
	 */
	public String toString() {
		return "promisory note (" + this.getContent().getAmount() + ")";
	}
}
