package letter;

@SuppressWarnings("serial")
public class MalformedLetterException extends IllegalArgumentException {

	public MalformedLetterException(String message) {
		super(message);
	}
}
