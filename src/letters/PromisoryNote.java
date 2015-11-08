package letters;

import city.Inhabitant;
import content.*;

public class PromisoryNote extends Letter<Money> {

	/*
	 * Constructor
	 */
    public PromisoryNote (Inhabitant sender, Inhabitant receiver, Money content) {
    	super(sender, receiver, content);
    }


    /*
	 * Methods
	 */
    
	@Override
	public double getCost() {
		return 1 + (this.content.getAmount()*0.01); 
		
	}

	@Override
	public void doAction() {
		Money amout = this.content;
		this.receiver.getBankAccount().credit(amout.getAmount());
		this.setOpened(true);
	}
}
