package letter;

import city.BankAccount;
import city.Inhabitant;
import content.*;
import out.Messages;
import out.TraceBuffer;

public class PromissoryNote extends Letter<Money> {

	//COMMISSION stands for the coefficient to calculate the extra cost of the letter based on its contents
	public final static double COMMISSION = 0.01;
	
	/*
	 * Constructor
	 */
	
	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Money content) {
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
		return (1 + (this.getAmount() * PromissoryNote.COMMISSION));

	}

	/**
	 * Opens the letter. Next, transfers money from the sender to the receiver.
	 * After that, the receiver send a thankful letter
	 */
	@Override
	public void doAction() {
		super.doAction();
		this.sender.getBankAccount().debit(this.getAmount());
		this.receiver.getBankAccount().credit(this.getAmount());
		TraceBuffer.add(Messages.receiverCredited(this));
		Text aText = new Text("Thanks for the money!");
		Letter<?> letter = new SimpleLetter(this.receiver, this.sender, aText);
		letter.getSender().sendLetter(letter);
	}

	/**
	 * @return the type of the letter with his content
	 */
	public String toString() {
		return "promissory note whose content is a " + this.content.toString();
	}
	
	
	/**
	 * Shortcut for <code>this.content.getAmount()</code>.
	 */
	public double getAmount() {
		return this.content.getAmount();
	}
	
	/**
	 * @param bankAccount
	 * @return true if the letter cost less than the amount on the bankAccount, otherwise, returns false
	 */
	@Override
	public boolean checkLetter(BankAccount bankAccount){
		return this.getCost() + this.getAmount() <= bankAccount.getAmount();
	}
}
