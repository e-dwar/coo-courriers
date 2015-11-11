package letters;

import city.*;
import content.*;

public class LetterFactory {

	private Inhabitant sender;
	private Inhabitant receiver;
	
	public LetterFactory() {
		City cityLambda = new City("Lambda");
		sender = new Inhabitant("Sender", cityLambda, new BankAccount(1000.0));
		receiver = new Inhabitant("Receiver", cityLambda, new BankAccount(1000.0));
	}
	
	public SimpleLetter createSimpleLetter(){
		Text aText = new Text("This is a fake letter.");
		return new SimpleLetter(sender, receiver, aText);
	}
	
	public PromisoryNote createPromisoryNote(){
		Money aMoney = new Money(200.0);
		return new PromisoryNote(sender, receiver, aMoney);
	}
	
	public PromisoryNote createPromisoryNote(double money){
		Money aMoney = new Money(money);
		return new PromisoryNote(sender, receiver, aMoney);
	}
	
	public RegisteredLetter createRLwithSL(){
		return new RegisteredLetter(createSimpleLetter());
	}
	
	public RegisteredLetter createRLwithPN(){
		return new RegisteredLetter(createPromisoryNote());
	}
	
	public UrgentLetter createUwithSL(){
		return new UrgentLetter(createSimpleLetter());
	}
	
	public UrgentLetter createUwithPN(){
		return new UrgentLetter(createPromisoryNote());
	}
	
	public UrgentLetter createUwithRLwithSL(){
		return new UrgentLetter(createRLwithSL());
	}
	
	public UrgentLetter createUwithRLwithPN(){
		return new UrgentLetter(createRLwithPN());
	}

}
