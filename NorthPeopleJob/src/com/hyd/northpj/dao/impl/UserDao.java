package com.hyd.northpj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hyd.northpj.dao.interfaces.UserDaoInterface;
import com.hyd.northpj.entity.User;
import com.hyd.northpj.util.HibernateSessionFactory;
import com.hyd.northpj.util.ValidateUtil;

public class UserDao implements UserDaoInterface {
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	private Query query;

	@Override
	public int insertUser(User user) throws Exception {
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		session.save(user);
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public String selectUserPassword(String username) throws Exception {
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		String password=null;
		query = session.createQuery("from User where username="
				+ username);
		@SuppressWarnings("unchecked")
		List<User> Users =	query.list();
		for (User tempUser : Users) {
			password = tempUser.getPassword();
		}
		tx.commit();
		session.close();
		return password;
	}

	@Override
	public int updateUserPassword(User user) throws Exception {  
/*		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		// TODO Auto-generated method stub
		String password=user.getPassword();
		//user=(User)session.get(User.class,user.getSn());
		//user.setPassword(password);
		//session.save(user);
		//tx.commit();
		query = session.createQuery("update User s set password="+password+"where s.username="
				+ user.getUsername());
		session.close();*/
		Session mySession=null;
		Transaction myTx=null;
		String updateQuery="update User set password='"+user.getPassword()+"' where username ='"+user.getUsername()+"'";
		System.out.println(updateQuery);
		try{
			mySession=HibernateSessionFactory.getSession();
			myTx=mySession.beginTransaction();
			mySession.createQuery(updateQuery).executeUpdate();
			myTx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(mySession!=null)
				mySession.close();
		}
		return 0;
	}

	@Override
	public int updateUserInformation(User user) throws Exception {
		// TODO Auto-generated method stub
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		//获取userName所对应的sn
		String myQuery="select sn from User where username='"+user.getUsername()+"'";
		int sn=(int) session.createQuery(myQuery).uniqueResult();
		User newUser=(User)session.get(User.class,1);
		ValidateUtil.copyProperty(newUser, user);
		Session mySession=HibernateSessionFactory.getSession();
		Transaction myTransation=mySession.beginTransaction();
		mySession.update(newUser);
		myTransation.commit();
		mySession.close();
		return 0;
	}

	@Override
	public User selectUserInformation(String username) throws Exception {
		// TODO Auto-generated method stub
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		query = session.createQuery("from User where username="
				+ username);
		@SuppressWarnings("unchecked")
		List<User> Users =	query.list();
		for (User tempUser : Users) {
			return tempUser;
		}
		session.close();
		return null;
	}
	

	@Override
	public int updateUserApplicationTime(User user) throws Exception {
		// TODO Auto-generated method stub
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		user=(User)session.get(User.class,user.getSn());
		user.setApplicationTime(user.getApplicationTime());
		session.save(user);
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateUserAcceptionProgress(User user) throws Exception {
		// TODO Auto-generated method stub
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		user=(User)session.get(User.class,user.getSn());
		user.setAcceptionProgress(user.getAcceptionProgress());
		session.save(user);
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateUserAppointmentTime(User user) throws Exception {
		// TODO Auto-generated method stub
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		user=(User)session.get(User.class,user.getSn());
		user.setAppointmentTime(user.getAppointmentTime());
		session.save(user);
		tx.commit();
		session.close();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUser() throws Exception {
		// TODO Auto-generated method stub
		if (!session.isOpen()) {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
		}
		session.clear();
		String sqlStatement="from User";
		query=session.createQuery(sqlStatement);
		List<User> myUserList=query.list();
		session.close();
		return myUserList;
	}

/*	public static void main(String[] args) throws Exception{
		UserDao ud=new UserDao();
		User u=new User();
		u=ud.selectUserInformation("13752142003");
		System.out.print(u.getPassword());
	}*/

}

