package com.deus.store.service;

import com.deus.store.domain.User;

public interface UserService {
	
	boolean checkUsername(String username);
	void regist(User user);
}
