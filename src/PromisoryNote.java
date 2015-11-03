public class PromisoryNote extends Letter<Money> {

    protected Letter letter;

    public PromisoryNote (Letter letter, Money x) {
        super(x);
        this.letter = letter;
    }

    public void print () {
        this.letter.print();
        System.out.print(" ");
        System.out.print(this.x.amount());
    }
}
