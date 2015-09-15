package com.shma.xml.dao;

import org.springframework.jdbc.core.JdbcTemplate;


public class BookStockImpl implements IBookStock {

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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
