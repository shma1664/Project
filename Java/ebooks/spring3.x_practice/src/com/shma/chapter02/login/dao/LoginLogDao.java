package com.shma.chapter02.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 插入登录日志
	 * @param userId 用户id
	 * @param ip 登录ip
	 * @param loginTime 登录时间
	 * @return
	 */
	public int insertLoginLog(int userId, String ip, String loginTime) {
		String sql = "insert into t_login_log(user_id, ip, login_time) values (?,?,?)";
		Object[] args = new Object[]{userId, ip, loginTime};
		return jdbcTemplate.update(sql, args);
	}
}
