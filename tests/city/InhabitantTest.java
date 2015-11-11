package city;

import static org.junit.Assert.*;

import org.junit.*;

import exceptions.NotEnoughMoneyException;
import letters.Letter;
import letters.LetterFactory;

public class InhabitantTest {

	private Inhabitant aInhabitant;
	private String inhabitantName;
	private BankAccount aBankAccount;
	private City aCity;
	private LetterFactory aLetterFactory;
	
	@Before
	public void init(){
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
	public void getCityTest(){
		assertEquals(aCity, aInhabitant.getCity());
	}
	
	@Test
	public void getBankAccountTest(){
		assertEquals(aBankAccount, aInhabitant.getBankAccount());
	}

	@Test
	public void sendLetterTest(){
		Letter<?> aSimpleLetter = this.aLetterFactory.createSimpleLetter();
		assertTrue(aInhabitant.getCity().getPostBox().isEmpty());
		try {
			aInhabitant.sendLetter(aSimpleLetter);
		} catch (NotEnoughMoneyException e) {}
		assertFalse(aInhabitant.getCity().getPostBox().isEmpty());
		assertTrue(aInhabitant.getCity().getPostBox().contains(aSimpleLetter));
	}
	
	@Test(expected=NotEnoughMoneyException.class)
	public void sendLetterWithouthEnoughMoneyTest() throws NotEnoughMoneyException{
		Letter<?> aPromisory = this.aLetterFactory.createPromisoryNote(1000000.0);
		aInhabitant.sendLetter(aPromisory);
	}
	
	@Test
	public void receiveLetterTest(){
		Letter<?> aUrgentLetter = this.aLetterFactory.createUwithRLwithPN();
		assertEquals(1000.0, aUrgentLetter.getReceiver().getBankAccount().getAmount(), 0.01);
		assertFalse(aUrgentLetter.getOpened());
		/*System.out.println("DEBUG A = " + aUrgentLetter.getReceiver().getBankAccount().getAmount());
		System.out.println("DEBUG B = " + aUrgentLetter.getSender().getBankAccount().getAmount());*/
		aInhabitant.receiveLetter(aUrgentLetter);
		
		/*System.out.println("DEBUG A = " +aUrgentLetter.getReceiver().getBankAccount().getAmount());
		System.out.println("DEBUG B = " + aUrgentLetter.getSender().getBankAccount().getAmount());*/
		assertEquals(1199.0, aUrgentLetter.getReceiver().getBankAccount().getAmount(), 0.01);
		//assertTrue(aUrgentLetter.getOpened());
		aInhabitant.receiveLetter(aUrgentLetter);
		assertEquals(1199.0, aUrgentLetter.getReceiver().getBankAccount().getAmount(), 0.01);
		assertTrue(aUrgentLetter.getOpened());
	}
}
