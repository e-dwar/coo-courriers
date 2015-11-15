import java.util.Random;

import out.Messages;
import out.TraceBuffer;
import city.*;
import content.*;
import letter.*;

public class Main {

	public static Random rdm = new Random(123456789);

	public static void main(String[] args) {
		try {
			run2();
		} catch (Exception e) {
			TraceBuffer.error(e);
		}
		TraceBuffer.flush();
	}

	/**
	 * Deuxième trace.
	 */
	public static void run2() {
		Letter<?> letter;
		int i, j;
		int nInhabitants = 10;
		int nLetters = 0;
		int nDays = 3;
		City disneyLand = new City("Disney Land");
		addInhabitants(disneyLand, nInhabitants);
		for (i = 0; i <= nDays; i++) {
			TraceBuffer.add(Messages.dayDbg(i + 1));
			disneyLand.distributeLetters();
			if (i < nDays) {
				nLetters = getRandomInt() % disneyLand.size() + 1;
				for (j = 0; j < nLetters; j++) {
					try {
						letter = getRandomLetter(disneyLand);
						letter.getSender().sendLetter(letter);
					} catch (Exception e) {
						TraceBuffer.error(e);
					}
				}
			}
			TraceBuffer.flush();
		}
	}

	/**
	 * Première trace.
	 */
	public static void run1() {
		SimpleLetter aLetter;
		PromissoryNote aPromissory;
		RegisteredLetter aRegistered;
		City disneyLand = new City("Disney Land");
		Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand, new BankAccount(5000.0));
		Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand, new BankAccount(5000.0));
		aLetter = new SimpleLetter(mickey, minnie, new Text("I need money !"));
		aRegistered = new RegisteredLetter(aLetter);
		aPromissory = new PromissoryNote(minnie, mickey, new Money(150));
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aLetter));
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aPromissory));
		TraceBuffer.add("Prix d'une registered = " + aRegistered.getCost() + "$");
		Letter<Content> aUrgent1 = new UrgentLetter(new RegisteredLetter(aLetter));
		Letter<Content> aUrgent2 = new RegisteredLetter(new UrgentLetter(aLetter));
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aUrgent1));
		TraceBuffer.cr();
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aUrgent2));
		mickey.sendLetter(aRegistered);
		minnie.sendLetter(aPromissory);
		disneyLand.distributeLetters();
	}

	/**
	 * Adds <code>n</code> inhabitant to the provided city.
	 * 
	 * @param city
	 * @param n
	 */
	public static void addInhabitants(City city, int n) {
		int i;
		String name;
		BankAccount bankAccount;
		for (i = 0; i < n; i++) {
			name = "Person #" + (i + 1);
			bankAccount = new BankAccount((getRandomInt() % 5 + 1) * 1000);
			city.addInhabitant(new Inhabitant(name, bankAccount));
		}
	}

	/**
	 * Gives a random combination of letters.
	 * 
	 * @param city The city from which to pick a sender and a receiver.
	 * @return A random letter.
	 * @throws Exception
	 */
	public static Letter<?> getRandomLetter(City city) throws Exception {

		// 000 simple letter
		// 001 promissory note
		// 010 registered letter
		// 100 urgent letter

		Inhabitant sender = getRandomInhabitant(city);
		Inhabitant receiver = getRandomInhabitant(city);
		int promissoryNote = getRandomInt() % 2;
		int registered = getRandomInt() % 2 << 1;
		int urgent = getRandomInt() % 2 << 2;

		switch (registered | urgent | promissoryNote) {
			case 0b001: // promissory note
				return getRandomPromissoryNote(sender, receiver);
			case 0b010: // simple letter + registered letter
				return new RegisteredLetter(getRandomSimpleLetter(sender, receiver));
			case 0b011: // promissory note + registered letter
				return new RegisteredLetter(getRandomPromissoryNote(sender, receiver));
			case 0b100: // simple letter + urgent letter
				return new UrgentLetter(getRandomSimpleLetter(sender, receiver));
			case 0b101: // promissory note + urgent letter
				return new UrgentLetter(getRandomPromissoryNote(sender, receiver));
			case 0b110: // simple letter + registered letter + urgent letter
				return new UrgentLetter(new RegisteredLetter(getRandomSimpleLetter(sender, receiver)));
			case 0b111: // promissory note + registered letter + urgent letter
				return new UrgentLetter(new RegisteredLetter(getRandomPromissoryNote(sender, receiver)));
			default: // simple letter
				return getRandomSimpleLetter(sender, receiver);
		}
	}

	/**
	 * Gives a simple letter with a random text content.
	 * 
	 * @param sender
	 * @param receiver
	 * @return A simple letter with a random text content.
	 */
	public static Letter<?> getRandomSimpleLetter(Inhabitant sender, Inhabitant receiver) {
		Text content = new Text("Hello " + receiver + "!\n\n - " + sender);
		return new SimpleLetter(sender, receiver, content);
	}

	/**
	 * Gives a promissory note with a random amount of money.
	 * 
	 * @param sender
	 * @param receiver
	 * @return A promissory note with a random amount of money.
	 */
	public static Letter<?> getRandomPromissoryNote(Inhabitant sender, Inhabitant receiver) {
		Money content = new Money(10 * (getRandomInt() % 5 + 1));
		return new PromissoryNote(sender, receiver, content);
	}

	/**
	 * Gives a random inhabitant from the provided city.
	 * 
	 * @return A random inhabitant from the provided city.
	 */
	public static Inhabitant getRandomInhabitant(City city) {
		return city.getInhabitant(getRandomInt() % city.size());
	}

	/**
	 * Gives an integer between 0 and Integer.MAX_VALUE - 1.
	 * 
	 * @return An integer between 0 and Integer.MAX_VALUE - 1.
	 */
	public static int getRandomInt() {
		return rdm.nextInt(Integer.MAX_VALUE);
	}
}
