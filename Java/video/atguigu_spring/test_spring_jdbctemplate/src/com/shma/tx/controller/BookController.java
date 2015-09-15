package com.shma.tx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shma.tx.service.IBookService;
import com.shma.tx.service.ICashierService;

@Controller("bookController")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICashierService cashierService;
	
	public void buyBook(int userId, int isbn) {
		bookService.purchase(userId, isbn);
	}
	
	public void checkOut(int userId, List<Integer> isbns) {
		cashierService.checkOut(userId, isbns);
	}
}
