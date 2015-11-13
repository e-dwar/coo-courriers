package out;

import city.Inhabitant;
import letter.Letter;

public class Messages {
	
	public static String letterSent(Letter<?> letter) {
		return "-> " + letter.getSender().getName() + " mails to " + letter.getReceiver().getName();
	}
	
	public static String letterReceived(Letter<?> letter) {
		return "<- " + letter.getSender().getName() + " receives a letter from " + letter.getReceiver().getName();
	}
	
	public static String senderAccount(Inhabitant sender) {
		return "- Sender account = " + sender.getBankAccount().getAmount();
	}
	
	public static String receiverAccount(Inhabitant receiver) {
		return "- Receiver account = " + receiver.getBankAccount().getAmount();
	}
	
	public static String senderDebited(Letter<?> letter){
		Inhabitant sender = letter.getSender();
		return "- " + letter.getCost() + " are debited from " + sender.getName() + " account whose balance is now " + sender.getBankAccount().getAmount();
	}
	
	public static String alreadyOpen() {
		return "This letter has already been opened.";
	}
	
	// DEBUG
	
	public static String xSentToYWithCostDbg(Letter<?> letter) {
		String sender = letter.getSender().getName();
		String receiver = letter.getReceiver().getName();
		double cost = letter.getCost();
		return sender + " a envoyé une lettre à " + receiver + " ce qui lui a coûté : " + cost + "$";
	}
}
