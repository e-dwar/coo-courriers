package content;

public class Text implements Content {

	/*
	 * Attributes
	 */
	private String text;

	/*
	 * Constructor
	 */
	public Text(String text) {
		this.text = text;
	}

	/*
	 * Methods
	 */

	/**
	 * Returns the value of the attribute text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * @return a string with the type of the content and with his content.
	 */
	public String toString()
	{
		return "text content ["+ this.text + "]";
	}
	
}
