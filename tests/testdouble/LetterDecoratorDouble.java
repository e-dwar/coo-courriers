package testdouble;

import letter.Letter;
import letter.LetterDecorator;

public class LetterDecoratorDouble extends LetterDecorator {

	public LetterDecoratorDouble(Letter<?> letter) {
		super(letter);
	}

	@Override
	public double getCost() {
		return 0;
	}
	
}
