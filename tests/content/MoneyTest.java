package content;

import static org.junit.Assert.*;

import org.junit.*;

public class MoneyTest {

	Money aMoneyContent;

	@Before
	public void init() {
		aMoneyContent = new Money(100.0);
	}

	@Test
	public void getAmountTest() {
		assertEquals(100.0, aMoneyContent.getAmount(), 0);
	}

}
