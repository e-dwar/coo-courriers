package letters;

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

	@Override
	public double getCost() {
		return 1 + (this.content.getAmount() * 0.01);

	}

	@Override
	public void doAction() {
		super.doAction();
		if(this.content.getAmount() <= this.sender.getBankAccount().getAmount()){
			this.sender.getBankAccount().debit(this.content.getAmount());
			this.receiver.getBankAccount().credit(this.content.getAmount());
			System.out.println("Test B" + this.receiver.getBankAccount().getAmount());

			Text aText = new Text("Thanks for the money!");
			Letter<?> letter = new SimpleLetter(this.receiver, this.sender, aText);
			
			super.sendBack(letter);
		}
	}
}
