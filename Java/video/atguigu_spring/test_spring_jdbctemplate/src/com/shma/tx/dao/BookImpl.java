package com.shma.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("book")
public class BookImpl implements IBook {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getBookPriceByisbn(int isbn) {
		String sql = "select price from t_book where isbn = ?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

}
