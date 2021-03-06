package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.*;

import city.BankAccount;
import testdouble.InhabitantDouble;

public abstract class LetterTest {

	protected Letter<?> letter;
	protected InhabitantDouble receiver;
	protected LetterFactory letterFactory = new LetterFactory();

	public abstract Letter<?> createLetter();

	@Before
	public void init() {
		letter = createLetter();
		receiver = (InhabitantDouble) letter.getReceiver();
	}

	@Test
	public void isUrgentTest() {
		assertFalse(letter.isUrgent());
	}
	
	@Test
	public void isPromissoryNoteTest(){
		assertFalse(letter.isPromissoryNote());
	}
	
	@Test
	public void positiveCostTest() {
		assertTrue(letter.getCost() > 0);
	}

	public void doActionTest() {
		assertFalse(letter.getOpened());
		letter.doAction();
		assertTrue(letter.getOpened());
	}
	
	@Test
	public void checkLetterTest(){
		BankAccount bankAccount = receiver.getBankAccount();
		SimpleLetter simpleLetter = letterFactory.createSimpleLetter();
		bankAccount.debit(bankAccount.getAmount());
		bankAccount.credit(SimpleLetter.COST * 2);
		assertTrue(simpleLetter.checkLetter(bankAccount));
		bankAccount.debit(bankAccount.getAmount());
		assertFalse(simpleLetter.checkLetter(bankAccount));
	}

}
