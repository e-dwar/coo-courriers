package city;

import static org.junit.Assert.*;

import org.junit.*;

import letter.Letter;
import letter.LetterFactory;

public class CityTest {

	private LetterFactory aLetterFactory;
	private City cityLambda;
	private String cityName;

	@Before
	public void init() {
		aLetterFactory = new LetterFactory();
		cityName = "Lambda";
		cityLambda = new City(cityName);
	}

	@Test
	public void getNameTest() {
		assertEquals(cityName, cityLambda.getName());
	}

	@Test
	public void setNameTest() {
		assertEquals(cityName, cityLambda.getName());
		cityLambda.setName("Temp");
		assertEquals("Temp", cityLambda.getName());
	}

	@Test
	public void getPostBoxTest() {
		assertNotNull(cityLambda.getPostBox());
		assertEquals(0, cityLambda.getPostBox().size());
	}

	@Test
	public void addLetterTest() {
		Letter<?> aSimpleLetter = this.aLetterFactory.createSimpleLetter();
		assertEquals(0, cityLambda.getPostBox().size());
		assertFalse(cityLambda.getPostBox().contains(aSimpleLetter));
		cityLambda.addLetter(aSimpleLetter);
		assertEquals(1, cityLambda.getPostBox().size());
		assertTrue(cityLambda.getPostBox().contains(aSimpleLetter));
	}

	@Test
	public void distributeLettersTest() {
		Letter<?> aPromissoryNote = this.aLetterFactory.createPromissoryNote();
		Letter<?> aRegisteredLetter = this.aLetterFactory.createRLwithSL();

		assertFalse(aPromissoryNote.getOpened());
		assertFalse(aRegisteredLetter.getOpened());

		assertTrue(cityLambda.getPostBox().isEmpty());
		cityLambda.addLetter(aPromissoryNote);
		cityLambda.addLetter(aRegisteredLetter);
		assertFalse(cityLambda.getPostBox().isEmpty());

		cityLambda.distributeLetters();
		assertTrue(aPromissoryNote.getOpened());
		assertTrue(aRegisteredLetter.getOpened());
	}

	@Test
	public void addInhabitantTest() {
		Inhabitant inhabitantLambda = new Inhabitant("inhabitantLambda", new BankAccount(1000.0));
		assertEquals(0, cityLambda.getInhabitants().size());
		cityLambda.addInhabitant(inhabitantLambda);
		assertEquals(1, cityLambda.getInhabitants().size());
		cityLambda.addInhabitant(inhabitantLambda);
		assertEquals(1, cityLambda.getInhabitants().size());
	}

	@Test
	public void getInhabitantTest() {
		Inhabitant inhabitantLambda = new Inhabitant("inhabitantLambda", new BankAccount(1000.0));
		cityLambda.addInhabitant(inhabitantLambda);
		assertEquals(inhabitantLambda, cityLambda.getInhabitant(0));
	}

	@Test
	public void sizeTest() {
		Inhabitant inhabitantLambda1 = new Inhabitant("inhabitantLambda1", new BankAccount(1000.0));
		Inhabitant inhabitantLambda2 = new Inhabitant("inhabitantLambda2", new BankAccount(1000.0));
		assertEquals(0, cityLambda.size());
		cityLambda.addInhabitant(inhabitantLambda1);
		assertEquals(1, cityLambda.size());
		cityLambda.addInhabitant(inhabitantLambda2);
		assertEquals(2, cityLambda.size());
	}

}
