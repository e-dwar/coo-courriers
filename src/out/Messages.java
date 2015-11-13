package out;

import city.Inhabitant;
import letter.Letter;

public class Messages {

	public static String alreadyOpen() {
		return "This letter has already been opened.";
	}

	public static String letterSent(Letter<?> letter) {
		return "-> " + letter.getSender() + " mails a " + letter + " to " + letter.getReceiver();
	}

	public static String letterReceived(Letter<?> letter) {
		return "<- " + letter.getReceiver() + " receives a " + letter + " from " + letter.getSender();
	}

	public static String senderAccount(Inhabitant sender) {
		return "- Sender account = " + sender.getBankAccount().getAmount();
	}

	public static String receiverAccount(Inhabitant receiver) {
		return "- Receiver account = " + receiver.getBankAccount().getAmount();
	}

	public static String senderDebited(Letter<?> letter) {
		String message = "";
		message += "- " + letter.getCost();
		message += " are debited from " + letter.getSender();
		message += " account whose balance is now ";
		message += letter.getSender().getBankAccount().getAmount();
		return message;
	}

	// DEBUG

	public static String xSentToYWithCostDbg(Letter<?> letter) {
		String message = "";
		message += letter.getSender() + " a envoyé une lettre à " + letter.getReceiver();
		message += " ce qui lui a coûté : " + letter.getCost() + "$";
		return message;
	}

	public static String dayDbg(int n) {
		return "\n------\nDAY " + n + "\n------\n";
	}
}
