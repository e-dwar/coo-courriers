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
}
