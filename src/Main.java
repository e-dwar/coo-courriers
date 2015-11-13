import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.*;
import letter.*;

public class Main {

	public static SimpleLetter aLetter;
	public static PromisoryNote aPromisory;
	public static RegisteredLetter aRegistered;
	public static int nMalformed = 0;

	public static void run() {

		/**
		 * Nous devons : - Créer une ville - Créer 100 habitants dans cette
		 * ville - Créer une méthode pour générer aléatoirement des courriers -
		 * Créer une méthode qui envoie des courriers sur plusieurs jours
		 */

		City disneyLand = new City("Disney Land");
		Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand, new BankAccount(5000.0));
		Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand, new BankAccount(5000.0));
		aLetter = new SimpleLetter(mickey, minnie, new Text("I need money !"));
		aRegistered = new RegisteredLetter(aLetter);
		aPromisory = new PromisoryNote(minnie, mickey, new Money(150));

		trace1();

		mickey.sendLetter(aRegistered);
		minnie.sendLetter(aPromisory);

		disneyLand.distributeLetters();

	}

	public static void trace1() {
		printSent(aLetter);
		printSent(aPromisory);
		System.out.println("Prix d'une registered = " + aRegistered.getCost() + "$");
		Letter<Content> aUrgent1 = new UrgentLetter(new RegisteredLetter(aLetter));
		Letter<Content> aUrgent2 = new RegisteredLetter(new UrgentLetter(aLetter));
		printSent(aUrgent1);
		System.out.println("\n");
		printSent(aUrgent2);
	}

	public static void printSent(Letter<?> letter) {
		String sender = letter.getSender().getName();
		String receiver = letter.getReceiver().getName();
		double cost = letter.getCost();
		System.out.println(sender + " a envoyé une lettre à " + receiver + " ce qui lui a coûté : " + cost + "$");
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
