package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import testdouble.LetterDecoratorDouble;

public class UrgentLetterTest extends LetterTest {

	@Test
	public void isUrgentTest() {
		assertTrue(letter.isUrgent());
	}

	@Test
	public void urgentOnceShouldPassTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		new UrgentLetter(new LetterDecoratorDouble(simpleLetter));
	}

	@Test(expected=MalformedLetterException.class)
	public void urgentMoreThanOnceShouldFailTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		new UrgentLetter(new LetterDecoratorDouble(new UrgentLetter(simpleLetter)));
	}

	@Override
	public Letter<?> createLetter() {
		return letterFactory.createUwithRLwithSL();
	}

}
