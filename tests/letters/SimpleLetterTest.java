package letters;

import letter.Letter;

import org.junit.Test;

public class SimpleLetterTest extends LetterTest {

	
	@Test
	public void doActionTest(){
		super.doActionTest();
	}
	
	public Letter<?> createLetter(){
		return letterFactory.createSimpleLetter();
	}

}
