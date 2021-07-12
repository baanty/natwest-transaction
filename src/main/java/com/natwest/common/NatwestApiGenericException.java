package com.natwest.common;

/**
 * Use this exception to identify 
 * generic API exceptions.
 * 
 * @author Pijush Kanti Das
 *
 */
public class NatwestApiGenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5921733200266701930L;

	public NatwestApiGenericException() {
		super();

	}

	public NatwestApiGenericException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public NatwestApiGenericException(String message, Throwable cause) {
		super(message, cause);

	}

	public NatwestApiGenericException(String message) {
		super(message);

	}

	public NatwestApiGenericException(Throwable cause) {
		super(cause);

	}

	
}
