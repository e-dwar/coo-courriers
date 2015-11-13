package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.Test;

import city.BankAccount;
import city.City;

import content.Money;

public class PromisoryNoteTest extends LetterTest {

	@Test
	public void doActionTest() {
		City city = letter.getSender().getCity();
		Money money = (Money) letter.getContent();
		BankAccount senderBankAccount = letter.getSender().getBankAccount();
		BankAccount receiverBankAccount = letter.getReceiver().getBankAccount();
		Double previousSenderAmount = senderBankAccount.getAmount();
		Double previousReceiverAmount = receiverBankAccount.getAmount();
		Double expectedSenderAmount = previousSenderAmount -  money.getAmount();
		Double expectedReceiverAmount = previousReceiverAmount + money.getAmount() - COST_OF_SIMPLE_LETTER;
		// tests
		assertEquals(0, city.getPostBox().size());
		super.doActionTest();
		assertEquals(expectedSenderAmount, senderBankAccount.getAmount(), 0.01);
		assertEquals(expectedReceiverAmount, receiverBankAccount.getAmount(), 0.01);
		assertEquals(1, city.getPostBox().size());
	}

	@Override
	public Letter<?> createLetter() {
		return letterFactory.createPromisoryNote();
	}

}
