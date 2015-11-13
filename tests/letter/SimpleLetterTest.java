package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.Test;

import content.Content;

public class SimpleLetterTest extends LetterTest {

	@Test
	public void doActionTest() {
		super.doActionTest();
	}

	@Test
	public void textContentTest() {
		assertTrue(letter.getContent() instanceof Content);
	}

	public Letter<?> createLetter() {
		return letterFactory.createSimpleLetter();
	}

}
