import java.util.Random;

import out.Messages;
import out.TraceBuffer;
import city.*;
import content.*;
import letter.*;

public class Main {

	public static Random rdm = new Random(123456789);

	/**
	 * Nous devons : - Créer une ville - Créer 100 habitants dans cette ville -
	 * Créer une méthode pour générer aléatoirement des courriers - Créer une
	 * méthode qui envoie des courriers sur plusieurs jours
	 */

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
		int i, j, nLetters = 0, days = 6;
		City disneyLand = new City("Disney Land");
		addAHundredInhabitants(disneyLand);
		for (i = 0; i < days; i++) {
			nLetters = getRandomInt() % disneyLand.size();
			for (j = 0; j < nLetters; j++) {
				try {
					disneyLand.getPostBox().add(getRandomLetter(disneyLand));
				} catch (Exception e) {
					TraceBuffer.error(e);
				}
			}
			disneyLand.distributeLetters();
		}
	}

	/**
	 * Première trace.
	 */
	public static void run1() {
		SimpleLetter aLetter;
		PromisoryNote aPromisory;
		RegisteredLetter aRegistered;
		City disneyLand = new City("Disney Land");
		Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand, new BankAccount(5000.0));
		Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand, new BankAccount(5000.0));
		aLetter = new SimpleLetter(mickey, minnie, new Text("I need money !"));
		aRegistered = new RegisteredLetter(aLetter);
		aPromisory = new PromisoryNote(minnie, mickey, new Money(150));
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aLetter));
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aPromisory));
		TraceBuffer.add("Prix d'une registered = " + aRegistered.getCost() + "$");
		Letter<Content> aUrgent1 = new UrgentLetter(new RegisteredLetter(aLetter));
		Letter<Content> aUrgent2 = new RegisteredLetter(new UrgentLetter(aLetter));
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aUrgent1));
		TraceBuffer.cr();
		TraceBuffer.add(Messages.xSentToYWithCostDbg(aUrgent2));
		mickey.sendLetter(aRegistered);
		minnie.sendLetter(aPromisory);
		disneyLand.distributeLetters();
	}

	/**
	 * Adds 100 inhabitant to the provided city.
	 * 
	 * @param city
	 */
	public static void addAHundredInhabitants(City city) {
		int i;
		String name;
		BankAccount bankAccount;
		for (i = 0; i < 100; i++) {
			name = "Person #" + (i + 1);
			bankAccount = new BankAccount((getRandomInt() % 5) * 1000);
			city.addInhabitant(new Inhabitant(name, bankAccount));
		}
	}

	public static Letter<?> getRandomLetter(City city) throws Exception {

		// 000 simple letter
		// 001 promisory note
		// 010 registered letter
		// 100 urgent letter

		Inhabitant sender = getRandomInhabitant(city);
		Inhabitant receiver = getRandomInhabitant(city);
		int promisoryNote = getRandomInt() % 2;
		int registered = getRandomInt() % 2 << 1;
		int urgent = getRandomInt() % 2 << 2;

		switch (registered | urgent | promisoryNote) {
			case 0b001: // promisory note
				return getRandomPromisoryNote(sender, receiver);
			case 0b010: // simple letter + registered letter
				return new RegisteredLetter(getRandomSimpleLetter(sender, receiver));
			case 0b011: // promisory note + registered letter
				return new RegisteredLetter(getRandomPromisoryNote(sender, receiver));
			case 0b100: // simple letter + urgent letter
				return new UrgentLetter(getRandomSimpleLetter(sender, receiver));
			case 0b101: // promisory note + urgent letter
				return new UrgentLetter(getRandomPromisoryNote(sender, receiver));
			case 0b110: // simple letter + registered letter + urgent letter
				return new UrgentLetter(new RegisteredLetter(getRandomSimpleLetter(sender, receiver)));
			case 0b111: // promisory note + registered letter + urgent letter
				return new UrgentLetter(new RegisteredLetter(getRandomPromisoryNote(sender, receiver)));
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
	 * Gives a promisory note with a random amount of money.
	 * 
	 * @param sender
	 * @param receiver
	 * @return A promisory note with a random amount of money.
	 */
	public static Letter<?> getRandomPromisoryNote(Inhabitant sender, Inhabitant receiver) {
		Money content = new Money(1000 * (getRandomInt() % 5));
		return new PromisoryNote(sender, receiver, content);
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
