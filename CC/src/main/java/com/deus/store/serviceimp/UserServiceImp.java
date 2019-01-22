package com.deus.store.serviceimp;

import com.deus.store.daoimpl.UserDaoImp;
import com.deus.store.domain.User;
import com.deus.store.service.UserService;

public class UserServiceImp implements UserService{

	@Override
	public boolean checkUsername(String username) {
		UserDaoImp userdaoimp = new UserDaoImp();
		return userdaoimp.findByName(username);
	}

	@Override
	public void regist(User user) {
		UserDaoImp userDao = new UserDaoImp();
		userDao.save(user);
		EmailUtils.sendEmail()
	}
	
}
