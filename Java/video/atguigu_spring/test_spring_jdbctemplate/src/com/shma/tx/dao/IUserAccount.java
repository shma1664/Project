package com.shma.tx.dao;

public interface IUserAccount {

	public int getAccount(int userId);
	
	public void updateAccount(int userId, int price);
}
