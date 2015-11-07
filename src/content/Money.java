package content;
public class Money implements Content {

	/*
	 * Attributes
	 */
    private int amount;

    /*
	 * Constructor
	 */
    public Money (int amount) {
        this.amount = amount;
    }

    /*
	 * Methods
	 */
    
    /**
     * Returns the value of the attribute amount.
     * @return the amount
     */
    public int getAmount () {
        return this.amount;
    }
}
