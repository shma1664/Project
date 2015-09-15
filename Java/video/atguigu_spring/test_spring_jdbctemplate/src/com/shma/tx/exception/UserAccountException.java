package com.shma.tx.exception;

public class UserAccountException extends RuntimeException {
	
	private static final long serialVersionUID = 8755354908288723123L;

	public UserAccountException() {
		super();
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountException(String message) {
		super(message);
	}

	public UserAccountException(Throwable cause) {
		super(cause);
	}

}
