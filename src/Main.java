import java.util.Random;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.*;
import letter.*;

public class Main {

	public static Random rdm = new Random(123456789);
	public static int nMalformed = 0;

	public static void run() {
		trace2();
	}

	public static void trace2() {
		int i;

		/**
		 * Nous devons : - Créer une ville - Créer 100 habitants dans cette
		 * ville - Créer une méthode pour générer aléatoirement des courriers -
		 * Créer une méthode qui envoie des courriers sur plusieurs jours
		 */

		City disneyLand = new City("Disney Land");
		addAHundredInhabitants(disneyLand);

		for (i = 0; i < 10; i++) {
			System.out.println(disneyLand.getInhabitant(getRandomInt() % disneyLand.size()));
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
	}
	
	public static void addAHundredInhabitants(City city){
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

	public static void main(String[] args) {
		try {
			run();
		} catch (MalformedLetterException e) {
			nMalformed++;
			System.out.println("lettres malformées: " + nMalformed + ".");
		}
	}
}
