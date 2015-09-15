package com.shma.reflection;

public class PrivateObject {

	private String privateString = null;

	public PrivateObject(String privateString) {
		super();
		this.privateString = privateString;
	}

	private String getPrivateString() {
		return privateString;
	}

	private void setPrivateString(String privateString) {
		this.privateString = privateString;
	}
}
