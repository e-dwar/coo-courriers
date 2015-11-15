package letter;

import city.City;
import testdouble.InhabitantDouble;
import letter.PromissoryNote;
import letter.RegisteredLetter;
import letter.SimpleLetter;
import letter.UrgentLetter;
import content.*;

public class LetterFactory {

	private InhabitantDouble sender;
	private InhabitantDouble receiver;

	public LetterFactory() {
		City city = new City("Alexandria");
		sender = new InhabitantDouble("Sender", city);
		receiver = new InhabitantDouble("Receiver", city);
	}

	/**
	 * @return an instance of a SimpleLetter
	 */
	public SimpleLetter createSimpleLetter() {
		Text aText = new Text("This is a fake letter.");
		return new SimpleLetter(sender, receiver, aText);
	}

	/**
	 * @return an instance of a PromissoryNote with a defined amount.
	 */
	public PromissoryNote createPromissoryNote() {
		Money aMoney = new Money(200.0);
		return new PromissoryNote(sender, receiver, aMoney);
	}

	/**
	 * @return an instance of a PromissoryNote without a defined amount.
	 */
	public PromissoryNote createPromissoryNote(double money) {
		Money aMoney = new Money(money);
		return new PromissoryNote(sender, receiver, aMoney);
	}

	/**
	 * @return an instance of a RegisteredLetter which is made of a
	 *         SimpleLetter.
	 */
	public RegisteredLetter createRLwithSL() {
		return new RegisteredLetter(createSimpleLetter());
	}

	/**
	 * @return an instance of a RegisteredLetter which is made of a
	 *         PromissoryNote.
	 */
	public RegisteredLetter createRLwithPN() {
		return new RegisteredLetter(createPromissoryNote());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a SimpleLetter.
	 */
	public UrgentLetter createUwithSL() {
		return new UrgentLetter(createSimpleLetter());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a PromissoryNote.
	 */
	public UrgentLetter createUwithPN() {
		return new UrgentLetter(createPromissoryNote());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a SimpleLetter and
	 *         a RegisteredLetter.
	 */
	public UrgentLetter createUwithRLwithSL() {
		return new UrgentLetter(createRLwithSL());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a PromissoryNote
	 *         and a RegisteredLetter.
	 */
	public UrgentLetter createUwithRLwithPN() {
		return new UrgentLetter(createRLwithPN());
	}

}
