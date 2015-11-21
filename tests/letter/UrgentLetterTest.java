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

	@Test(expected=MalformedLetterException.class)
	public void urgentMoreThanOnceShouldFailTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		new UrgentLetter<Letter<?>>(new LetterDecoratorDouble<Letter<?>>(new UrgentLetter<SimpleLetter>(simpleLetter)));
	}

	@Override
	public Letter<?> createLetter() {
		return letterFactory.createUwithRLwithSL();
	}
	
	@Test
	public void getCostTest(){
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		PromissoryNote promissoryNote = letterFactory.createPromissoryNote(500);
		
		UrgentLetter<Letter<?>> urgentLetter = new UrgentLetter<Letter<?>>(new RegisteredLetter<SimpleLetter>(simpleLetter));
		RegisteredLetter<Letter<?>> registeredLetter = new RegisteredLetter<Letter<?>>(new UrgentLetter<SimpleLetter>(simpleLetter));
		
		UrgentLetter<Letter<?>> urgentLetter2 = new UrgentLetter<Letter<?>>(new RegisteredLetter<PromissoryNote>(promissoryNote));
		RegisteredLetter<Letter<?>> registeredLetter2 = new RegisteredLetter<Letter<?>>(new UrgentLetter<PromissoryNote>(promissoryNote));
		
		
		Double expectedCost = (SimpleLetter.COST + RegisteredLetter.COST_AOR) * UrgentLetter.COEFFICIENT;
		Double expectedCostForPromissory = ((SimpleLetter.COST + (promissoryNote.getAmount() * PromissoryNote.COMMISSION) + RegisteredLetter.COST_AOR) * UrgentLetter.COEFFICIENT);
		assertEquals(expectedCost, urgentLetter.getCost(),0);
		assertEquals(expectedCost, registeredLetter.getCost(), 0);
		
		assertEquals(expectedCostForPromissory, urgentLetter2.getCost(),0);
		assertEquals(expectedCostForPromissory, registeredLetter2.getCost(), 0);
	}

}
