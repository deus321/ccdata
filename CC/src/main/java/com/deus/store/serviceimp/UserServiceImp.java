package com.deus.store.serviceimp;

import com.deus.store.daoimpl.UserDaoImp;
import com.deus.store.service.UserService;

public class UserServiceImp implements UserService{

	@Override
	public boolean checkUsername(String username) {
		UserDaoImp userdaoimp = new UserDaoImp();
		return userdaoimp.findByName(username);
	}
	
}
