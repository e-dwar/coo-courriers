import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.Content;
import content.Money;
import content.Text;
import letters.Letter;
import letters.PromisoryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;

public class Main {

    public static void main (String[] args) {

        /*Letter souha = new SimpleLetter(new Text("allo Souha"));

        Letter valentin = new PromisoryNote(
            new SimpleLetter(new Text("allo Valentin")), 
            new Money(1)
        );

        Letter edouard = new PromisoryNote(
            new PromisoryNote(
                new SimpleLetter(new Text("allo Edouard")), 
                new Money(2)
            ), 
            new Money(1)
        );

        System.out.println("\n----");
        souha.print();
        System.out.println("\n----");
        valentin.print();
        System.out.println("\n----");
        edouard.print();
        System.out.println("\n----");*/
    	
    	
    	/** Nous devons :
    	 * - Créer une ville
    	 * - Créer 100 habitants dans cette ville
    	 * - Créer une méthode pour générer aléatoirement des courriers
    	 * - Créer une méthode qui envoie des courriers sur plusieurs jours
    	 */
    	
    	City disneyLand = new City("Disney Land");
    	
    	Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand, new BankAccount(5000));
    	Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand, new BankAccount(5000));
    	
    	Letter<Text> aLetter = new SimpleLetter(mickey, minnie, new Text("I need money !"));
    	Letter<Content> aRegistered = new RegisteredLetter(aLetter);
    	Letter<Money> aPromisory = new PromisoryNote(minnie, mickey, new Money(150));
    	
    	System.out.println(aLetter.getSender().getName() + " a envoyé une lettre à " + aLetter.getReceiver().getName() + " ce qui lui a coûté : " + aLetter.getCost() + "$");
    	System.out.println(aPromisory.getSender().getName() + " a envoyé une lettre à " + aPromisory.getReceiver().getName() + " ce qui lui a coûté : " + aPromisory.getCost() + "$");
    	System.out.println("Prix d'une registered = "+ aRegistered.getCost() + "$");

    	disneyLand.distributeLetters();
    }
}
