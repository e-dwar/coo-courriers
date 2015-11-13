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
			run1();
		} catch (MalformedLetterException e) {
			TraceBuffer.add("Error: malformed letter");
		} catch (Exception e) {
			TraceBuffer.add("Error: " + e.getMessage());
		}
		TraceBuffer.flush();
	}

	public static void run2() {
		int i, index;
		City disneyLand = new City("Disney Land");
		addAHundredInhabitants(disneyLand);
		for (i = 0; i < 10; i++) {
			index = getRandomInt() % disneyLand.size();
			TraceBuffer.add(disneyLand.getInhabitant(index));
		}
	}

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

	public static int getRandomInt() {
		return rdm.nextInt(Integer.MAX_VALUE);
	}
}
