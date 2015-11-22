import java.util.Random;

import out.Messages;
import out.TraceBuffer;
import city.*;
import content.*;
import letter.*;

public class Main {

	private static Random rdm = new Random();

	public static void main(String[] args) {
		try {
			run();
		} catch (Exception e) {
			TraceBuffer.error(e);
		}
		TraceBuffer.flush();
	}

	/**
	 * Deuxième trace.
	 */
	private static void run() {
		Letter<?> letter;
		int i, j;
		int nInhabitants = 100;
		int nLetters = 0;
		int nDays = 6;
		City disneyLand = new City("DisneyLand");
		addInhabitants(disneyLand, nInhabitants);
		
		for (i = 0; i <= nDays; i++) {
			TraceBuffer.add(Messages.dayDbg(i + 1));
			disneyLand.distributeLetters();
			if (i < nDays) {
				nLetters = getRandomInt(5);
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
	 * Adds <code>n</code> inhabitant to the provided city.
	 * 
	 * @param city
	 * @param n
	 */
	private static void addInhabitants(City city, int n) {
		int i;
		String name;
		BankAccount bankAccount;
		Inhabitant inhabitant;
		for (i = 0; i < n; i++) {
			name = "Person #" + (i + 1);
			bankAccount = new BankAccount(getRandomInt(5) * 1000);
			inhabitant = new Inhabitant(name, bankAccount);
			inhabitant.setAlias("#" + (i + 1) + "");
			city.addInhabitant(inhabitant);
		}
	}

	/**
	 * Gives a random combination of letters.
	 * 
	 * @param city The city from which to pick a sender and a receiver.
	 * @return A random letter.
	 */
	private static Letter<?> getRandomLetter(City city) {
		Letter<?> letter;
		Inhabitant sender = getRandomInhabitant(city);
		Inhabitant receiver = getRandomInhabitant(city);
		if (getRandomInt(2) == 1) {
			Money content = new Money(10 * (getRandomInt(5) + 1));
			letter = new PromissoryNote(sender, receiver, content);
		} else {
			Text content = new Text("Hello " + receiver + "! - " + sender);
			letter = new SimpleLetter(sender, receiver, content);
		}
		if (getRandomInt(2) == 1) {
			letter = new RegisteredLetter<Letter<?>>(letter);
		}
		if (getRandomInt(2) == 1) {
			letter = new UrgentLetter<Letter<?>>(letter);
		}
		return letter;
	}

	/**
	 * Gives a random inhabitant from the provided city.
	 * 
	 * @return A random inhabitant from the provided city.
	 */
	private static Inhabitant getRandomInhabitant(City city) {
		return city.getInhabitant(getRandomInt(city.size()));
	}

	/**
	 * Gives an integer between 0 and Integer.MAX_VALUE - 1.
	 * @param sup TODO
	 * 
	 * @return An integer between 0 and Integer.MAX_VALUE - 1.
	 */
	private static int getRandomInt(int sup) {
		return rdm.nextInt(sup);
	}
}
