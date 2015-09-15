package com.shma.xml.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookImpl implements IBook {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getBookPriceByisbn(int isbn) {
		String sql = "select price from t_book where isbn = ?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
