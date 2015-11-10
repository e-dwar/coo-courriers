package exceptions;

public class NotEnoughMoneyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyException() {
	}

	public NotEnoughMoneyException(String message) {
		super(message);
	}

	public NotEnoughMoneyException(Throwable cause) {
		super(cause);
	}

	public NotEnoughMoneyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughMoneyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
