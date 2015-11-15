package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.Test;

import city.BankAccount;
import city.City;

import content.Money;

public class PromissoryNoteTest extends LetterTest {

	@Test
	public void doActionTest() {
		Double amount = ((PromissoryNote) letter).getAmount();
		City city = letter.getSender().getCity();
		BankAccount senderBankAccount = letter.getSender().getBankAccount();
		BankAccount receiverBankAccount = letter.getReceiver().getBankAccount();
		Double previousSenderAmount = senderBankAccount.getAmount();
		Double previousReceiverAmount = receiverBankAccount.getAmount();

		// The sender has already paid the letter's cost,
		// so we're just expecting that the money has been well debited
		Double expectedSenderAmount = previousSenderAmount - amount;

		// The receiver shall receive an amount of money,
		// and he has to send back a letter
		Double expectedReceiverAmount = previousReceiverAmount + amount - COST_OF_SIMPLE_LETTER;

		// tests
		assertEquals(0, city.getPostBox().size());
		super.doActionTest();
		assertEquals(expectedSenderAmount, senderBankAccount.getAmount(), 0.01);
		assertEquals(expectedReceiverAmount, receiverBankAccount.getAmount(), 0.01);
		assertEquals(1, city.getPostBox().size());
	}

	@Test
	public void getCostTest() {
		Double expectedCost = COST_OF_SIMPLE_LETTER;
		Money money = (Money) letter.getContent();
		expectedCost += (money.getAmount() * 0.01);
		assertEquals(expectedCost, letter.getCost(), 0.01);
	}

	@Override
	public Letter<?> createLetter() {
		return letterFactory.createPromissoryNote();
	}

}
