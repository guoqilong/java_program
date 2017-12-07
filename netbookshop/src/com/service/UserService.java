package com.service;

import java.util.List;

import com.model.User;
/**
 * 用户业务类
 */
public interface UserService {
	/** 新增用户 */
	public User register(User user);
	/**删除用户*/
	public boolean remove(int[] ids);  
	/**修改用户*/
	public boolean modify(User user);
	/**查询所有用户*/
	public List<User> getUsers();	
	/**用户登录*/
	public boolean login(String name,String password); 
	/** 检查用户名是否存在 */
	public boolean checkUserName(String username);
	boolean remove(int id);
}
