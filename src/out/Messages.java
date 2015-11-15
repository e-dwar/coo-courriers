package out;

import city.Inhabitant;
import letter.Letter;

public class Messages {

	/**
	 * @return a message when the letter is already opened.
	 */
	public static String alreadyOpen() {
		return "This letter has already been opened.";
	}

	/**
	 * @param letter
	 * @return a message when a letter is sent. Display the sender and the
	 *         receiver.
	 */
	public static String letterSent(Letter<?> letter) {
		return "-> " + letter.getSender() + " mails a " + letter + " to " + letter.getReceiver();
	}

	/**
	 * @param letter
	 * @return a message when a letter is received. Display the sender and the
	 *         receiver.
	 */
	public static String letterReceived(Letter<?> letter) {
		return "<- " + letter.getReceiver() + " receives a " + letter + " from " + letter.getSender();
	}

	/**
	 * @param sender
	 * @return a message with the sender's account amount.
	 */
	public static String senderAccount(Inhabitant sender) {
		return "- Sender account = " + sender.getBankAccount().getAmount();
	}

	/**
	 * @param sender
	 * @return a message with the receiver's account amount.
	 */
	public static String receiverAccount(Inhabitant receiver) {
		return "- Receiver account = " + receiver.getBankAccount().getAmount();
	}

	/**
	 * @param letter
	 * @return a message when the sender debit something on his bank account.
	 */
	public static String senderDebited(Letter<?> letter) {
		String message = "";
		message += "- " + letter.getCost();
		message += " are debited from " + letter.getSender();
		message += " account whose balance is now ";
		message += letter.getSender().getBankAccount().getAmount();
		return message;
	}

	/**
	 * @param n
	 * @return a message with the day's number
	 */
	public static String dayDbg(int n) {
		return "\n------\nDAY " + n + "\n------\n";
	}

	// DEBUG
	public static String xSentToYWithCostDbg(Letter<?> letter) {
		String message = "";
		message += letter.getSender() + " a envoyé une lettre à " + letter.getReceiver();
		message += " ce qui lui a coûté : " + letter.getCost() + "$";
		return message;
	}

}
