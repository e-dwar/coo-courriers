package out;

import java.util.ArrayList;

public class TraceBuffer {

	protected static ArrayList<String> buffer = new ArrayList<String>();

	/**
	 * Adds a message to the buffer.
	 * 
	 * @param line
	 */
	public static void add(Object line) {
		buffer.add(line.toString());
	}

	/**
	 * Adds a formatted exception to the buffer.
	 * 
	 * @param e
	 */
	public static void error(Exception e) {
		add("Error: " + e);
	}

	/**
	 * Adds a carriage return to the buffer.
	 */
	public static void cr() {
		add("");
	}

	/**
	 * Displays the buffer and clears it by the same way.
	 */
	public static void flush() {
		while (buffer.size() > 0) {
			System.out.println(buffer.remove(0));
		}
	}
}
