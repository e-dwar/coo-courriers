package city;

import static org.junit.Assert.*;

import org.junit.*;

import letter.Letter;
import letter.LetterFactory;

public class InhabitantTest {

	private Inhabitant aInhabitant;
	private String inhabitantName;
	private BankAccount aBankAccount;
	private City aCity;
	private LetterFactory aLetterFactory;

	@Before
	public void init() {
		aCity = new City("City Lambda");
		aBankAccount = new BankAccount(500.0);
		inhabitantName = "Lambda";
		aInhabitant = new Inhabitant(inhabitantName, aCity, aBankAccount);
		aLetterFactory = new LetterFactory();
	}

	@Test
	public void getNameTest() {
		assertEquals(inhabitantName, aInhabitant.getName());
	}

	@Test
	public void getCityTest() {
		assertEquals(aCity, aInhabitant.getCity());
	}

	@Test
	public void getBankAccountTest() {
		assertEquals(aBankAccount, aInhabitant.getBankAccount());
	}

	@Test
	public void sendLetterTest() {
		Letter<?> aSimpleLetter = this.aLetterFactory.createSimpleLetter();
		assertTrue(aInhabitant.getCity().getPostBox().isEmpty());
		aInhabitant.sendLetter(aSimpleLetter);
		assertFalse(aInhabitant.getCity().getPostBox().isEmpty());
		assertTrue(aInhabitant.getCity().getPostBox().contains(aSimpleLetter));
	}
	
	@Test
	public void sendLetterWithEnoughMoneyTest(){
		Letter<?> aPromissory = this.aLetterFactory.createPromissoryNote(1000000.0);
		assertTrue(aInhabitant.getCity().getPostBox().isEmpty());
		aInhabitant.sendLetter(aPromissory);
		assertTrue(aInhabitant.getCity().getPostBox().isEmpty());
		assertFalse(aInhabitant.getCity().getPostBox().contains(aPromissory));
	}

	@Test
	public void checkLetterTest() {
		Letter<?> aSimple = this.aLetterFactory.createSimpleLetter();
		Letter<?> aPromissory = this.aLetterFactory.createPromissoryNote(1000000.0);
		//assertTrue(aInhabitant.checkLetter(aSimple));
		assertTrue(aSimple.checkLetter(aInhabitant.getBankAccount()));
		//assertFalse(aInhabitant.checkLetter(aPromissory));
		assertFalse(aPromissory.checkLetter(aInhabitant.getBankAccount()));
	}

	@Test
	public void receiveLetterTest() {
		Letter<?> aUrgentLetter = this.aLetterFactory.createUwithRLwithPN();
		assertFalse(aUrgentLetter.getOpened());
		aInhabitant.receiveLetter(aUrgentLetter);
		assertTrue(aUrgentLetter.getOpened());
		aInhabitant.receiveLetter(aUrgentLetter);
		assertTrue(aUrgentLetter.getOpened());
	}
}
