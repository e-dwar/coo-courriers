public class Main {

    public static void main (String[] args) {

        Letter souha = new SimpleLetter(new Text("allo Souha"));

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
        System.out.println("\n----");
    }
}
