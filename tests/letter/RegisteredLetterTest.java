package letter;

import static org.junit.Assert.*;
import letter.Letter;
import testdouble.LetterDecoratorDouble;

import org.junit.*;

import city.City;

public class RegisteredLetterTest extends LetterTest {

	@Test
	public void doActionTest() {
		City city = letter.getSender().getCity();
		assertEquals(0, city.getPostBox().size());
		super.doActionTest();
		assertEquals(1, city.getPostBox().size());
	}

	@Test
	public void getCostTest() {
		Double expectedCost = SimpleLetter.COST + RegisteredLetter.COST_AOR;
		assertEquals(expectedCost, letter.getCost(), 0);
	}

	@Test
	public void receiverSendsAcknowledgment() {
		assertEquals(0, receiver.numberOfLetterSent);
		createLetter().doAction();
		assertEquals(1, receiver.numberOfLetterSent);
	}
	
	@Test
	public void registeredOnceShouldPassTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		new RegisteredLetter<Letter<?>>(new LetterDecoratorDouble<SimpleLetter>(simpleLetter));
	}
	
	@Test(expected=MalformedLetterException.class)
	public void registeredMoreThanOnceShouldFailTest() {
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		new RegisteredLetter<Letter<?>>(new LetterDecoratorDouble<Letter<?>>(new RegisteredLetter<SimpleLetter>(simpleLetter)));
	}

	public Letter<?> createLetter() {
		return letterFactory.createRLwithSL();
	}

}
