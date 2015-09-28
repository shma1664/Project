package com.shma.chapter01.bank;

public class MoneyExecption extends RuntimeException {

	private static final long serialVersionUID = -6124117960525976157L;

	public MoneyExecption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoneyExecption(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public MoneyExecption(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public MoneyExecption(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MoneyExecption(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
