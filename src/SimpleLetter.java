public class SimpleLetter extends Letter<Text> {

    public SimpleLetter (Text x) {
        super(x);
    }

    public void print () {
        System.out.print(this.x.text());
    }
}
