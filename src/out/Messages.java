package out;

import city.Inhabitant;
import content.Money;
import letter.Letter;

public class Messages {

	/**
	 * @param letter
	 * @return a message when a letter is sent. Display the sender and the
	 *         receiver.
	 */
	public static String letterSent(Letter<?> letter) {
		String message = lineHeadingTo(letter);
		message += "-> " + letter.getSender() + " mails " + letter + " to ";
		message += letter.getReceiver() + " for a cost of " + letter.getCost() + "$";
		return message;
	}

	/**
	 * @param letter
	 * @return a message when a letter is received. Display the sender and the
	 *         receiver.
	 */
	public static String letterReceived(Letter<?> letter) {
		String message = lineHeadingFrom(letter);
		message += "<- " + letter.getReceiver() + " receives " + letter + " from ";
		message += letter.getSender();
		return message;
	}

	/**
	 * @param letter
	 * @return a message when the sender debit something on his bank account.
	 */
	public static String senderDebited(Letter<?> letter, double amount) {
		String message = "";
		message += "- " + amount + "$";
		message += " are debited from " + letter.getSender();
		message += " account whose balance is now ";
		message += letter.getSender().getBalance() + "$";
		return message;
	}

	/**
	 * @param letter
	 * @return a message when the receiver credit money on his bank account.
	 */
	public static String receiverCredited(Letter<Money> letter, double amount) {
		String message = "";
		message += "- " + amount + "$";
		message += " are credited to " + letter.getReceiver();
		message += " account whose balance is now ";
		message += letter.getReceiver().getBalance() + "$";
		return message;
	}

	/**
	 * @param n
	 * @return a message with the day's number
	 */
	public static String dayDbg(int n) {
		return "\n\n# Day " + n + "\n";
	}

	// privates

	private static String lineHeadingTo(Letter<?> letter) {
		String message = "";
		message += "\nLetter: " + letterDescription(letter);
		message += "\nPeople: " + getInhabitantDescription(letter.getSender());
		message += " > " + getInhabitantDescription(letter.getReceiver());
		return message + "\n";
	}

	private static String lineHeadingFrom(Letter<?> letter) {
		String message = "";
		message += "\nLetter: " + letterDescription(letter);
		message += "\nPeople: " + getInhabitantDescription(letter.getReceiver());
		message += " < " + getInhabitantDescription(letter.getSender());
		return message + "\n";
	}
	
	private static String letterDescription(Letter<?> letter) {
		String message = "";
		try {
			while (true) {
				message += letter.getDescription().split(" ")[1].charAt(0);
				letter = (Letter<?>) letter.getContent();
			}
		} catch (ClassCastException e) {
			message = message.toUpperCase();
		}
		if (isAnswerExpected(letter)) {
			message += " (answer expected)";
		}
		return message;
	}

	private static boolean isAnswerExpected(Letter<?> letter) {
		return letter.isPromissoryNote() || letter.isRegistered();
	}

	private static String getInhabitantDescription(Inhabitant inhabitant) {
		return inhabitant.getName() + " [" + inhabitant.getBalance() + "$]";
	}

}
