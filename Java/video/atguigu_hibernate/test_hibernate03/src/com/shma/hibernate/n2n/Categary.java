package com.shma.hibernate.n2n;

import java.util.HashSet;

import java.util.Set;

public class Categary {

	private int cateId;
	
	private String cateName;
	
	private Set<Item> items = new HashSet<>();

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
