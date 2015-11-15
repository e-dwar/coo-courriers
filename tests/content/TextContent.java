package content;

import static org.junit.Assert.*;

import org.junit.*;

public class TextContent {

	Text aTextContent;

	@Before
	public void init() {
		aTextContent = new Text("Lorem ipsum");
	}

	@Test
	public void getTextTest() {
		assertEquals("Lorem ipsum", aTextContent.getText());
	}

}
