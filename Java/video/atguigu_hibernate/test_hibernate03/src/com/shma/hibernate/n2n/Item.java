package com.shma.hibernate.n2n;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private int itemId;
	
	private String itemName;
	
	private Set<Categary> categaries = new HashSet<>();

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Set<Categary> getCategaries() {
		return categaries;
	}

	public void setCategaries(Set<Categary> categaries) {
		this.categaries = categaries;
	}
	
}
