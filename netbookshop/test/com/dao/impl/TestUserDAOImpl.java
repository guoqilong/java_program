package com.dao.impl;

import org.junit.Test;

import com.dao.UserDAO;
import com.model.User;

public class TestUserDAOImpl {
	@Test
	public void testSave() {
		UserDAO dao = new UserDAOImpl();
		User u = new User();
		u.setName("郭旗龙");
		u.setPassword("123");
		
		System.out.println("a user have saved , this id is :" + dao.save(u).getId());
	}
}
