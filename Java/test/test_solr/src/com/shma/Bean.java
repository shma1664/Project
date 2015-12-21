package com.shma;

import org.apache.solr.client.solrj.beans.Field;

public class Bean {

	@Field
	private int id;
	@Field
	private String content;
	@Field
	private int type;
	@Field
	private int weight;
	@Field
	private int online;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}

}
