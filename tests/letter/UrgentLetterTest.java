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
		new UrgentLetter<Letter<?>>(new LetterDecoratorDouble<SimpleLetter>(simpleLetter));
	}

	@Test(expected = MalformedLetterException.class)
	public void urgentMoreThanOnceShouldFailTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		new UrgentLetter<Letter<?>>(new LetterDecoratorDouble<Letter<?>>(new UrgentLetter<SimpleLetter>(simpleLetter)));
	}

	@Override
	public Letter<?> createLetter() {
		return letterFactory.createUwithRLwithSL();
	}

	@Test
	public void getCostTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		PromissoryNote promissoryNote = letterFactory.createPromissoryNote(500);

		UrgentLetter<Letter<?>> urgentLetter = new UrgentLetter<Letter<?>>(new RegisteredLetter<SimpleLetter>(simpleLetter));

		UrgentLetter<Letter<?>> urgentLetter2 = new UrgentLetter<Letter<?>>(new RegisteredLetter<PromissoryNote>(promissoryNote));

		Double expectedCost = (SimpleLetter.COST + RegisteredLetter.EXTRA_COST) * UrgentLetter.COEFFICIENT;
		Double expectedCostForPromissory = ((SimpleLetter.COST + (promissoryNote.getAmount() * PromissoryNote.COMMISSION) + RegisteredLetter.EXTRA_COST) * UrgentLetter.COEFFICIENT);
		assertEquals(expectedCost, urgentLetter.getCost(), 0);

		assertEquals(expectedCostForPromissory, urgentLetter2.getCost(), 0);
	}

}
