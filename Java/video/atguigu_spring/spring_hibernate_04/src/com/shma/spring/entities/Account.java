package com.shma.spring.entities;

public class Account {

	private int id;
	private int userId;
	private int account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", userId=" + userId + ", account=" + account + "]";
	}

}
