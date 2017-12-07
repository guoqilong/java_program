package com.service.impl;

import java.util.List;

import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.model.User;
import com.service.UserService;

public abstract class UserServieImpl implements UserService {
	UserDAO userDao = new UserDAOImpl();
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}
	public boolean remove(int id){
		// TODO Auto-generated method stub
		
		return userDao.delete(id);
	} 

	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		return userDao.login(name, password);
	}

	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.checkUserName(username);
	}

}
