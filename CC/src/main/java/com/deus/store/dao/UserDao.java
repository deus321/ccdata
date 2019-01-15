package com.deus.store.dao;

public interface UserDao {
	void login();
	void register();
	boolean findByName(String username);
}
