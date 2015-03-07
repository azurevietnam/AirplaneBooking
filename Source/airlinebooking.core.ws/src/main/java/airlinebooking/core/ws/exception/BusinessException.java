package airlinebooking.core.ws.exception;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -348400309731808613L;

	/**
	 * Instantiates a new bussiness exception.
	 */
	public BusinessException() {
	}

	/**
	 * Instantiates a new bussiness exception.
	 * 
	 * @param message
	 *            the message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new bussiness exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new bussiness exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
