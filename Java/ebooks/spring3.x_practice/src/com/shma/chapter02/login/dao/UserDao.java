package com.shma.chapter02.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.shma.chapter02.login.domain.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 验证登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return 审核个数
	 */
	public int getMatchCount(String userName, String password) {
		
		String sql = "select count(user_id) from t_user where user_name=? and password=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{userName, password}, Integer.class);
	}
	
	/**
	 * 通过用户名查找用户信息
	 * @param userName 用户名
	 * @return
	 */
	public User findUserByUserName(String userName) {
		
		String sql = "select user_id, user_name, credits, last_visit_time, last_ip"
				+ " from t_user where user_name=? limit 1";
		
		final User user = new User();
		
		/**
		 * RowCallbackHandler 基于行，无需再调用next()方法
		 */
		jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setCredits(rs.getInt("credits"));
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setLastVisit(rs.getTimestamp("last_visit_time"));
				user.setLastIp(rs.getString("last_ip"));
			}
		});
		
		return user;
	}
	
	/**
	 * 更新登录信息
	 * @param lastVisitTime
	 * @param lastIp
	 * @param credits
	 * @return
	 */
	public int updateLoginInfo(String lastVisitTime, String lastIp, int credits) {
		String sql = "update t_user set last_visit_time=?, last_ip=?, credits=?";
		return jdbcTemplate.update(sql, lastVisitTime, lastIp, credits);
	}
}
