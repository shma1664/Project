package com.shma.xml.dao;

public interface IBookStock {

	public void updateBookStock(int isbn);
	
	public int getBookStockByIsbn(int isbn);
}
