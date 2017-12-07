package com.dao;

import java.util.List;

import com.model.User;
/**
 * 用户数据访问对象接口	
 */
public interface UserDAO {
	/** 新增用户 */
	public User save(User user);
	/**删除用户*/
	public boolean delete(int id);  
	/**修改用户*/
	public boolean update(User user);
	/**查询所有用户*/
	public List<User> findAll();	
	/**用户登录*/
	public boolean login(String name,String password); 
	/** 检查用户名是否存在 */
	public boolean checkUserName(String username);
}
