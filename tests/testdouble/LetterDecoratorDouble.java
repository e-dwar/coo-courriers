package testdouble;

import letter.Letter;
import letter.LetterDecorator;

public class LetterDecoratorDouble<L extends Letter<?>> extends LetterDecorator<L> {

	public LetterDecoratorDouble(L letter) {
		super(letter);
	}

	@Override
	public double getCost() {
		return 0;
	}

	@Override
	public String getDescription() {
		return "a letter decorator";
	}
	
}
