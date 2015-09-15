package com.shma;

import java.io.Serializable;

public class Msg implements Serializable {
	
	private static final long serialVersionUID = -948478514538813354L;

	private int id;
	
	private long money;
	
	private long sourceUserId;
	
	private long getUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public long getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(long sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public long getGetUserId() {
		return getUserId;
	}

	public void setGetUserId(long getUserId) {
		this.getUserId = getUserId;
	}

	@Override
	public String toString() {
		return "Msg [id=" + id + ", money=" + money + ", sourceUserId="
				+ sourceUserId + ", getUserId=" + getUserId + "]";
	}

}
