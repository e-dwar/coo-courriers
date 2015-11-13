package out;

import city.Inhabitant;
import letter.Letter;

public class Messages {
	
	public static String mailSent(Letter<?> letter) {
		return "-> " + letter.getSender().getName() + " mails to " + letter.getReceiver().getName();
	}
	
	public static String senderDebited(Letter<?> letter){
		Inhabitant sender = letter.getSender();
		return "- " + letter.getCost() + " are debited from " + sender.getName() + " account whose balance is now " + sender.getBankAccount().getAmount();
	}
}
