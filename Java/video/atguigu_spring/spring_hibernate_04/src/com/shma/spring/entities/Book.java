package com.shma.spring.entities;

public class Book {

	private int id;
	private int isbn;
	private String bookName;
	private int price;
	private int stock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookName=" + bookName + ", price=" + price + ", stock=" + stock
				+ "]";
	}

}
