package com.shma.xml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class UserAccountImpl implements IUserAccount {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getAccount(int userId) {
		String sql = "select account from t_user_account where user_id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, userId);
	}

	@Override
	public void updateAccount(int userId, int price) {
		String sql = "update t_user_account set account = account - ? where user_id = ?";
		jdbcTemplate.update(sql, price, userId);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
