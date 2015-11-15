package letter;

@SuppressWarnings("serial")
public class MalformedLetterException extends IllegalArgumentException {

	public MalformedLetterException() {
		super("malformed letter");
	}
}
