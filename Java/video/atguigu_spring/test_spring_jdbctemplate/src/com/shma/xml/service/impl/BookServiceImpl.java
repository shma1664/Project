package com.shma.xml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shma.tx.dao.IBook;
import com.shma.tx.dao.IBookStock;
import com.shma.tx.dao.IUserAccount;
import com.shma.tx.exception.BookStockException;
import com.shma.tx.exception.UserAccountException;
import com.shma.xml.service.IBookService;

public class BookServiceImpl implements IBookService {

	private IBook book;
	
	private IUserAccount userAccount;

	private IBookStock bookStock;
	
	@Override
	public void purchase(int userId, int isbn) {
		
		int bookPrice = book.getBookPriceByisbn(isbn);
		
		int account = userAccount.getAccount(userId);
		
		int stock = bookStock.getBookStockByIsbn(isbn);
		
		if(stock <= 0) {
			throw new BookStockException("¿â´æ²»×ã");
		}
		
		bookStock.updateBookStock(isbn);
		
		if(account < bookPrice) {
			throw new UserAccountException("Óà¶î²»×ã");
		}
		
		userAccount.updateAccount(userId, bookPrice);
	}

	public IBook getBook() {
		return book;
	}

	public void setBook(IBook book) {
		this.book = book;
	}

	public IUserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(IUserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public IBookStock getBookStock() {
		return bookStock;
	}

	public void setBookStock(IBookStock bookStock) {
		this.bookStock = bookStock;
	}

}
