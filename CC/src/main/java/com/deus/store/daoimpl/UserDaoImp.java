package com.deus.store.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.deus.store.dao.UserDao;
import com.deus.store.domain.User;
import com.deus.store.utils.JDBCUtils;

public class UserDaoImp implements UserDao{

	@Override
	public void login() {
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean findByName(String username) {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "SELECT * FROM `user` WHERE `username` = ?";
		try {
			Object[] user = qr.query(sql, username, new ArrayHandler());
			if (user == null) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(User user){
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "INSERT INTO `user` VALUES (?,?,?, ?,?,? ,?,?,?, ?)";
		Object[] params = { user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
				user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),
				user.getCode()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
