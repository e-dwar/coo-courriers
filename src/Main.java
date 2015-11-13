import java.util.Random;

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
		int nMalformed = 0;
		try {
			trace1();
		} catch (MalformedLetterException e) {
			nMalformed++;
		}
		System.out.println("lettres malformées: " + nMalformed + ".");
	}

	public static void trace2() {
		int i, index;
		City disneyLand = new City("Disney Land");
		addAHundredInhabitants(disneyLand);
		for (i = 0; i < 10; i++) {
			index = getRandomInt() % disneyLand.size();
			System.out.println(disneyLand.getInhabitant(index));
		}
	}

	public static void trace1() {
		SimpleLetter aLetter;
		PromisoryNote aPromisory;
		RegisteredLetter aRegistered;
		City disneyLand = new City("Disney Land");
		Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand, new BankAccount(5000.0));
		Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand, new BankAccount(5000.0));
		aLetter = new SimpleLetter(mickey, minnie, new Text("I need money !"));
		aRegistered = new RegisteredLetter(aLetter);
		aPromisory = new PromisoryNote(minnie, mickey, new Money(150));
		printSent(aLetter);
		printSent(aPromisory);
		System.out.println("Prix d'une registered = " + aRegistered.getCost() + "$");
		Letter<Content> aUrgent1 = new UrgentLetter(new RegisteredLetter(aLetter));
		Letter<Content> aUrgent2 = new RegisteredLetter(new UrgentLetter(aLetter));
		printSent(aUrgent1);
		System.out.println("\n");
		printSent(aUrgent2);
		mickey.sendLetter(aRegistered);
		minnie.sendLetter(aPromisory);
		disneyLand.distributeLetters();
		TraceBuffer.flush();
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

	public static void printSent(Letter<?> letter) {
		String sender = letter.getSender().getName();
		String receiver = letter.getReceiver().getName();
		double cost = letter.getCost();
		System.out.println(sender + " a envoyé une lettre à " + receiver + " ce qui lui a coûté : " + cost + "$");
	}

	public static int getRandomInt() {
		return rdm.nextInt(Integer.MAX_VALUE);
	}
}
