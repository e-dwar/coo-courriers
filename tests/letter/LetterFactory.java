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
	public RegisteredLetter<SimpleLetter> createRLwithSL() {
		return new RegisteredLetter<SimpleLetter>(createSimpleLetter());
	}

	/**
	 * @return an instance of a RegisteredLetter which is made of a
	 *         PromissoryNote.
	 */
	public RegisteredLetter<PromissoryNote> createRLwithPN() {
		return new RegisteredLetter<PromissoryNote>(createPromissoryNote());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a SimpleLetter.
	 */
	public UrgentLetter<SimpleLetter> createUwithSL() {
		return new UrgentLetter<SimpleLetter>(createSimpleLetter());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a PromissoryNote.
	 */
	public UrgentLetter<PromissoryNote> createUwithPN() {
		return new UrgentLetter<PromissoryNote>(createPromissoryNote());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a SimpleLetter and
	 *         a RegisteredLetter.
	 */
	public UrgentLetter<RegisteredLetter<?>> createUwithRLwithSL() {
		return new UrgentLetter<RegisteredLetter<?>>(createRLwithSL());
	}

	/**
	 * @return an instance of a UrgentLetter which is made of a PromissoryNote
	 *         and a RegisteredLetter.
	 */
	public UrgentLetter<RegisteredLetter<?>> createUwithRLwithPN() {
		return new UrgentLetter<RegisteredLetter<?>>(createRLwithPN());
	}

}
