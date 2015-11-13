import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.*;
import exceptions.NotEnoughMoneyException;
import letter.*;

public class Main {

	public static void main(String[] args) {

		try {
			run();
		} catch (IllegalArgumentException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public static void run() {

		/**
		 * Nous devons : - Créer une ville - Créer 100 habitants dans cette
		 * ville - Créer une méthode pour générer aléatoirement des courriers -
		 * Créer une méthode qui envoie des courriers sur plusieurs jours
		 */

		City disneyLand = new City("Disney Land");

		Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand,
				new BankAccount(5000.0));
		Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand,
				new BankAccount(5000.0));

		Letter<Text> aLetter = new SimpleLetter(mickey, minnie, new Text(
				"I need money !"));
		Letter<Content> aRegistered = new RegisteredLetter(aLetter);
		Letter<Money> aPromisory = new PromisoryNote(minnie, mickey, new Money(
				150));

		try {
			mickey.sendLetter(aRegistered);
			minnie.sendLetter(aPromisory);
		} catch (NotEnoughMoneyException exception) {
			System.out.println("Error : " + exception.getMessage());
		}
		/*
		System.out.println(aLetter.getSender().getName()
				+ " a envoyé une lettre à " + aLetter.getReceiver().getName()
				+ " ce qui lui a coûté : " + aLetter.getCost() + "$");
		System.out.println(aPromisory.getSender().getName()
				+ " a envoyé une lettre à "
				+ aPromisory.getReceiver().getName() + " ce qui lui a coûté : "
				+ aPromisory.getCost() + "$");
		System.out.println("Prix d'une registered = " + aRegistered.getCost()
				+ "$");
		Letter<Content> aUrgent1 = new UrgentLetter(new RegisteredLetter(
				aLetter));
		Letter<Content> aUrgent2 = new RegisteredLetter(new UrgentLetter(
				aLetter));
		System.out.println(aUrgent1.getSender().getName()
				+ " a envoyé une lettre à " + aUrgent1.getReceiver().getName()
				+ " ce qui lui a coûté : " + aUrgent1.getCost() + "$\n\n");
		System.out.println(aUrgent2.getSender().getName()
				+ " a envoyé une lettre à " + aUrgent2.getReceiver().getName()
				+ " ce qui lui a coûté : " + aUrgent2.getCost() + "$");*/

		disneyLand.distributeLetters();

	}
}
