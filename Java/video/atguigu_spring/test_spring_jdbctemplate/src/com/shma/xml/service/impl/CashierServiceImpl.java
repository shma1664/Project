package com.shma.xml.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shma.xml.service.IBookService;
import com.shma.xml.service.ICashierService;

public class CashierServiceImpl implements ICashierService {

	private IBookService bookService;
	
	@Override
	public void checkOut(int userId, List<Integer> isbns) {
		for(Integer isbn : isbns) {
			bookService.purchase(userId, isbn);
		}
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

}
