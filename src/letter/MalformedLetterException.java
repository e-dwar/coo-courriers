package letter;

@SuppressWarnings("serial")
public class MalformedLetterException extends IllegalArgumentException {

	public MalformedLetterException() {
		super("malformed letter");
	}

	public MalformedLetterException(String message) {
		super(message);
	}
}
