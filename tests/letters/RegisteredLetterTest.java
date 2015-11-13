package letters;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.*;

import city.City;

public class RegisteredLetterTest extends LetterTest {
	
	public Letter<?> createLetter(){
		return letterFactory.createRLwithSL();
	}
	
	@Test
	public void doActionTest(){
		City city = letter.getSender().getCity();
		assertEquals(0, city.getPostBox().size());
		super.doActionTest();
		assertEquals(1, city.getPostBox().size());
	}
	
	
}
