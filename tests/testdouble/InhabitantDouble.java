package testdouble;

import letter.Letter;
import city.BankAccount;
import city.City;
import city.Inhabitant;

public class InhabitantDouble extends Inhabitant {

	public int numberOfLetterSent;

	public InhabitantDouble(String name, City city) {
		super(name, city, new BankAccount(1000));
		numberOfLetterSent = 0;
	}

	public boolean sendLetter(Letter<?> letter) {
		boolean isValid = super.sendLetter(letter);
		if (isValid) {
			numberOfLetterSent++;
		}
		return isValid;
	}
}
