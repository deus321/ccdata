package com.deus.store.dao;

import com.deus.store.domain.User;

public interface UserDao{
	void login();
	void save(User user);
	boolean findByName(String username);
}
