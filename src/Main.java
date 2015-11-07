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
    	 * - Cr�er une ville
    	 * - Cr�er 100 habitants dans cette ville
    	 * - Cr�er une m�thode pour g�n�rer al�atoirement des courriers
    	 * - Cr�er une m�thode qui envoie des courriers sur plusieurs jours
    	 */
    	
    	City disneyLand = new City("Disney Land");
    	
    	Inhabitant mickey = new Inhabitant("Mickey Mouse", disneyLand, new BankAccount(5000));
    	Inhabitant minnie = new Inhabitant("Minnie Mouse", disneyLand, new BankAccount(5000));
    	
    	Letter<Text> aLetter = new SimpleLetter(mickey, minnie, new Text("I need money !"));
    	Letter<Content> aRegistered = new RegisteredLetter(aLetter);
    	Letter<Money> aPromisory = new PromisoryNote(minnie, mickey, new Money(150));
    	
    	System.out.println(aLetter.getSender().getName() + " a envoy� une lettre � " + aLetter.getReceiver().getName() + " ce qui lui a co�t� : " + aLetter.getCost() + "$");
    	System.out.println(aPromisory.getSender().getName() + " a envoy� une lettre � " + aPromisory.getReceiver().getName() + " ce qui lui a co�t� : " + aPromisory.getCost() + "$");
    	System.out.println("Prix d'une registered = "+ aRegistered.getCost() + "$");

    	disneyLand.distributeLetters();
    }
}
