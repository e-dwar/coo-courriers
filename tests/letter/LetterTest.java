package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.*;

public abstract class LetterTest {

	protected Letter<?> letter;
	protected LetterFactory letterFactory = new LetterFactory();
	
	protected final double COST_OF_SIMPLE_LETTER = 1 ;
	
	@Before
	public void init(){
		letter = createLetter();
	}
	
	public void doActionTest(){
		assertFalse(letter.getOpened());
		letter.doAction();
		assertTrue(letter.getOpened());
		
	}
	
	public abstract Letter<?> createLetter();

}
