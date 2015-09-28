package com.shma.chapter06.timeout;

public class TimeoutException extends RuntimeException {

	private static final long serialVersionUID = 5151683148951538666L;

	public TimeoutException(String msg) {
		super(msg);
	}
}
