package com.shma.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookStock")
public class BookStockImpl implements IBookStock {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateBookStock(int isbn) {
		String sql = "update t_book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public int getBookStockByIsbn(int isbn) {
		String sql = "select stock from t_book_stock where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

}
