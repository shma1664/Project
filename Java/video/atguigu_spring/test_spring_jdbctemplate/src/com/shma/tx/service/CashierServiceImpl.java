package com.shma.tx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cashierService")
public class CashierServiceImpl implements ICashierService {

	@Autowired
	private IBookService bookService;
	
	@Transactional
	@Override
	public void checkOut(int userId, List<Integer> isbns) {
		for(Integer isbn : isbns) {
			bookService.purchase(userId, isbn);
		}
	}

}
