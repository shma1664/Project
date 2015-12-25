package com.shma.chapter02.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shma.chapter02.login.dao.LoginLogDao;
import com.shma.chapter02.login.dao.UserDao;
import com.shma.chapter02.login.domain.User;

@Service
public class UserService {

	@Autowired
	private LoginLogDao loginLogDao;
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean hasMatchUser(String userName, String password) {
		
		int count = userDao.getMatchCount(userName, password);
		
		return count > 0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	/**
	 * 登录成功后操作记录
	 * @return
	 */
	public boolean loginSuccess(int userId, String loginTime, String ip, int credits) {
		
		// 更新t_user表ip和time信息
		int state = 0;
		
		state = userDao.updateLoginInfo(loginTime, ip, credits);
		
		if(state > 0) {
			// 插入登录日志
			state = loginLogDao.insertLoginLog(userId, ip, loginTime);
		}
		
		return state > 0;
		
	}
}
