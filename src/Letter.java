public abstract class Letter<T extends Content> {

    protected T x;

    public Letter (T x) {
        this.x = x;
    }

    public abstract void print ();
}
