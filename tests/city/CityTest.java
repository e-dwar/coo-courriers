package city;

import static org.junit.Assert.*;

import org.junit.*;

import letter.Letter;
import letters.LetterFactory;

public class CityTest {
	
	private LetterFactory aLetterFactory;
	private City cityLambda;
	private String cityName;
	
	@Before
	public void init(){
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
	public void getPostBoxTest(){
		assertNotNull(cityLambda.getPostBox());
	}
	
	@Test
	public void addLetterTest(){
		Letter<?> aSimpleLetter = this.aLetterFactory.createSimpleLetter();
		assertEquals(0, cityLambda.getPostBox().size());
		assertFalse(cityLambda.getPostBox().contains(aSimpleLetter));
		cityLambda.addLetter(aSimpleLetter);
		assertEquals(1, cityLambda.getPostBox().size());
		assertTrue(cityLambda.getPostBox().contains(aSimpleLetter));
		cityLambda.addLetter(aSimpleLetter);
		assertEquals(1, cityLambda.getPostBox().size());
	}
	
	@Test
	public void distributeLettersTest(){
		Letter<?> aPromisoryNote = this.aLetterFactory.createPromisoryNote();
		Letter<?> aRegisteredLetter = this.aLetterFactory.createRLwithSL();
		
		assertFalse(aPromisoryNote.getOpened());
		assertFalse(aRegisteredLetter.getOpened());
		
		assertTrue(cityLambda.getPostBox().isEmpty());
		cityLambda.distributeLetters();
		
		assertFalse(aPromisoryNote.getOpened());
		assertFalse(aRegisteredLetter.getOpened());
		
		
		cityLambda.addLetter(aPromisoryNote);
		cityLambda.addLetter(aRegisteredLetter);
		
		assertFalse(cityLambda.getPostBox().isEmpty());
		
		assertFalse(aPromisoryNote.getOpened());
		assertFalse(aRegisteredLetter.getOpened());
		cityLambda.distributeLetters();
		assertTrue(aPromisoryNote.getOpened());
		assertTrue(aRegisteredLetter.getOpened());
	}

}
