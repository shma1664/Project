package com.shma.jdbctemplate.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.shma.jdbctemplate.entity.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void save(User user) {
		String sql = "insert into myusers(myuname, sex, pname, address, email, tel) values (?,?,?,?,?,?)";
		saveByNameParameter(user);
		saveByNameParameter2(user);
		jdbcTemplate.update(sql, user.getUserName(), user.getSex(), user.getpName(), user.getAddress(), user.getEmail(),
				user.getTel());

	}
	
	public void saveByNameParameter(User user) {
		String sql = "insert into myusers(myuname, sex, pname, address, email, tel) values (:username,:sex,:pname,:address,:email,:tel)";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", user.getUserName());
		paramMap.put("sex", user.getSex());
		paramMap.put("pname", user.getpName());
		paramMap.put("address", user.getAddress());
		paramMap.put("email", user.getEmail());
		paramMap.put("tel", user.getTel());
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	public void saveByNameParameter2(User user) {
		String sql = "insert into myusers(myuname, sex, pname, address, email, tel) values (:userName,:sex,:pName,:address,:email,:tel)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}

	@Override
	public void del(User user) {
		String sql = "delete from myusers where myuserid = ?";
		jdbcTemplate.update(sql, user.getUserId());
	}

	@Override
	public void modify(User user) {
		String sql = "update myusers set myuname=?, sex=?, pname=?, address=?, email=?, tel=? where myuserid = ?";
		jdbcTemplate.update(sql, user.getUserName(), user.getSex(), user.getpName(), user.getAddress(), user.getEmail(), user.getTel(),
				user.getUserId());
	}

	@Override
	public User query(int id) {
		String sql = "select myuserid userId, myuname userName, sex sex, pname pName, address address, email email, tel tel from myusers where myuserid = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return user;
	}

	@Override
	public List<User> queryAll() {
		String sql = "select myuserid userId, myuname userName, sex sex, pname pName, address address, email email, tel tel from myusers";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> users = jdbcTemplate.query(sql, rowMapper);
		return users;
	}

	@Override
	public void batchSave(List<User> users) {
		String sql = "insert into myusers(myuname, sex, pname, address, email, tel) values (?,?,?,?,?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		for(User user : users) {
			Object[] object = new Object[]{user.getUserName(), user.getSex(), user.getpName(), user.getAddress(), user.getEmail(), user.getTel()};
			batchArgs.add(object);
		}
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

}
