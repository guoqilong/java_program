package com.util;





import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	static {
		try {
		/** 在当前目录下hibernate。cfg.xml配置文件，并将配置信息读入到内存*/
		configuration = new Configuration().configure();
		/**由configuration类创建SessionFactory类实例 ，为创建session类实例做准备 */
		sessionFactory	 = new configuration.buildSessionFactory();
		}catch(Throwable ex) {
			ex.printStackTrace();
			System.out.println();
		}
	}
	/**
	 * 获取SessionFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Configuration getConfiguration() {
		return configuration;
	}
	public static void rebuilSessionFactory() {
		synchronized (sessionFactory) {
			try {
				sessionFactory = getConfiguration().buildSessionFactory();
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}	
	}
	/**
	 * 获得session对象
	 * @return
	 */
	public static Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static void close() {
		try {
			sessionFactory.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭Session的对象
	 * @param session
	 */
	public static void closeSession(Session session) {
		try {
			if(null != session) {
				session.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 事务回滚
	 * @param transaction
	 */
	public static void rollbackTransaction(Transaction transaction) {
		try {
			if(null != transaction) {
				transaction.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 统一的查询方法
	 * 返回一个list集合
	 */
	public static List exeQuery(String hql) throws Exception{
		List list = null;
		Transaction transcation = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transcation = session.beginTransaction();
			
			list = session.createQuery(hql).list();
			transcation.commit();
			HibernateUtil.closeSession(session);
		}catch(Exception he) {
			he.printStackTrace();
			HibernateUtil.rollbackTransaction(transcation);
		}finally {
			HibernateUtil.closeSession(session);
		}
		return list;
	}
	
	/**
	 * 分页查询
	 * 返回一个list集合
	 */
	public static List exeQueryPage(String hql,int start,int end) throws Exception{
		List list = null;
		Transaction transcation = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transcation = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			list = query.list();
			
			transcation.commit();
			HibernateUtil.closeSession(session);
		}catch(Exception he) {
			he.printStackTrace();
			HibernateUtil.rollbackTransaction(transcation);
		}finally {
			HibernateUtil.closeSession(session);
		}
		return list;
	}
	/**
	 * 删除
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public static boolean exeDelete(String hql) throws Exception{
		boolean flag = false;
		Transaction transcation = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transcation = session.beginTransaction();
			
			session.createQuery(hql);
			
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
}
