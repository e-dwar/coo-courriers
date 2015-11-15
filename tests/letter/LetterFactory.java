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

	/**
	 * @return an instance of a SimpleLetter
	 */
	public SimpleLetter createSimpleLetter() {
		Text aText = new Text("This is a fake letter.");
		return new SimpleLetter(sender, receiver, aText);
	}

	/**
	 * @return an instance of a PromisoryNote with a defined amount.
	 */
	public PromisoryNote createPromisoryNote() {
		Money aMoney = new Money(200.0);
		return new PromisoryNote(sender, receiver, aMoney);
	}

	/**
	 * @return an instance of a PromisoryNote without a defined amount.
	 */
	public PromisoryNote createPromisoryNote(double money) {
		Money aMoney = new Money(money);
		return new PromisoryNote(sender, receiver, aMoney);
	}

	/**
	 * @return an instance of a RegisteredLetter which is made of a SimpleLetter.
	 */
	public RegisteredLetter createRLwithSL() {
		return new RegisteredLetter(createSimpleLetter());
	}

	/**
	 * @return an instance of a RegisteredLetter which is made of a PromisoryNote.
	 */
	public RegisteredLetter createRLwithPN() {
		return new RegisteredLetter(createPromisoryNote());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a SimpleLetter.
	 */
	public UrgentLetter createUwithSL() {
		return new UrgentLetter(createSimpleLetter());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a PromisoryNote.
	 */
	public UrgentLetter createUwithPN() {
		return new UrgentLetter(createPromisoryNote());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a SimpleLetter and a RegisteredLetter.
	 */
	public UrgentLetter createUwithRLwithSL() {
		return new UrgentLetter(createRLwithSL());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a PromisoryNote and a RegisteredLetter.
	 */
	public UrgentLetter createUwithRLwithPN() {
		return new UrgentLetter(createRLwithPN());
	}

}
