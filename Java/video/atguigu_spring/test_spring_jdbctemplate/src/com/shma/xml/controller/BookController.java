package com.shma.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shma.tx.service.IBookService;
import com.shma.tx.service.ICashierService;

public class BookController {

	private IBookService bookService;
	
	private ICashierService cashierService;
	
	public void buyBook(int userId, int isbn) {
		bookService.purchase(userId, isbn);
	}
	
	public void checkOut(int userId, List<Integer> isbns) {
		cashierService.checkOut(userId, isbns);
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public ICashierService getCashierService() {
		return cashierService;
	}

	public void setCashierService(ICashierService cashierService) {
		this.cashierService = cashierService;
	}
}
