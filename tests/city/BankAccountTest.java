package city;

import static org.junit.Assert.*;

import org.junit.*;

public class BankAccountTest {
	BankAccount bankAccount;

	@Before
	public void init() {
		bankAccount = new BankAccount(1000.0);
	}

	@Test
	public void getAmountTest() {
		assertEquals(1000.0, bankAccount.getAmount(), 0);
	}

	@Test
	public void creditTest() {
		assertEquals(1000.0, bankAccount.getAmount(), 0);
		bankAccount.credit(100.0);
		assertEquals(1100.0, bankAccount.getAmount(), 0);
	}

	@Test
	public void debitTest() {
		assertEquals(1000.0, bankAccount.getAmount(), 0);
		bankAccount.debit(100.0);
		assertEquals(900.0, bankAccount.getAmount(), 0);
	}

}
