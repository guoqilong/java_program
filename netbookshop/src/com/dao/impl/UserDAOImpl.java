package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UserDAO;
import com.model.User;
import com.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		User u = null;
		Transaction transcation = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transcation = session.beginTransaction();
			
			u = (User)session.save(user);
			
			transcation.commit();
			HibernateUtil.closeSession(session);
			
		}catch(Exception he) {
			he.printStackTrace();
			
			HibernateUtil.rollbackTransaction(transcation);
		}finally {
			HibernateUtil.closeSession(session);
		}
		return u;
	
	}

	@Override
	public boolean delete(int id){
		// TODO Auto-generated method stub
		String hql = "delete from User where id="+id;	
		try {
			return HibernateUtil.exeDelete(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			
		
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Transaction transcation = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transcation = session.beginTransaction();
			
			User u = (User)session.load(User.class, user.getId());
			u.setName(user.getName());
			u.setPassword(user.getPassword());
			u.setAddr(user.getAddr());
			u.setEmail(user.getEmail());
			u.setPhonenum(user.getPhonenum());
			u.setQQnum(user.getQQnum());
			
			transcation.commit();
			HibernateUtil.closeSession(session);
			flag = true;
		}catch(Exception he) {
			he.printStackTrace();
			flag = false;
			HibernateUtil.rollbackTransaction(transcation);
		}finally {
			HibernateUtil.closeSession(session);
		}
		return flag;
	}

	private Session load(Class<User> class1, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String hql = "from user";
		try {
			return HibernateUtil.exeQuery(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		String hql = "from User name ="+ name +"and password ="+password;
		try {
			if(HibernateUtil.exeQuery(hql).size() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		String hql = "from User name ="+ username;
		try {
			if(HibernateUtil.exeQuery(hql).size() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}

}
