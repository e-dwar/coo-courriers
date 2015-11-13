package letter;

import testdouble.InhabitantDouble;
import letter.PromisoryNote;
import letter.RegisteredLetter;
import letter.SimpleLetter;
import letter.UrgentLetter;
import content.*;

public class LetterFactory {

	private InhabitantDouble sender;
	private InhabitantDouble receiver;

	public LetterFactory() {
		sender = new InhabitantDouble("Sender");
		receiver = new InhabitantDouble("Receiver");
	}

	public SimpleLetter createSimpleLetter() {
		Text aText = new Text("This is a fake letter.");
		return new SimpleLetter(sender, receiver, aText);
	}

	public PromisoryNote createPromisoryNote() {
		Money aMoney = new Money(200.0);
		return new PromisoryNote(sender, receiver, aMoney);
	}

	public PromisoryNote createPromisoryNote(double money) {
		Money aMoney = new Money(money);
		return new PromisoryNote(sender, receiver, aMoney);
	}

	public RegisteredLetter createRLwithSL() {
		return new RegisteredLetter(createSimpleLetter());
	}

	public RegisteredLetter createRLwithPN() {
		return new RegisteredLetter(createPromisoryNote());
	}

	public UrgentLetter createUwithSL() {
		return new UrgentLetter(createSimpleLetter());
	}

	public UrgentLetter createUwithPN() {
		return new UrgentLetter(createPromisoryNote());
	}

	public UrgentLetter createUwithRLwithSL() {
		return new UrgentLetter(createRLwithSL());
	}

	public UrgentLetter createUwithRLwithPN() {
		return new UrgentLetter(createRLwithPN());
	}

}
