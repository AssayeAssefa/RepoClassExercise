package com.revature.dao.imp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createCriteria(User.class).list();
		s.close();
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
//		User u = (User) s.load(User.class, id);
//		System.out.println(u);
		User u = (User) s.get(User.class, id);
		s.close();
		return u;
	}

	@Override
	public User createUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		
		Session s = HibernateUtil.getSession();		
		Criteria crit = s.createCriteria(User.class);
		crit.add(Restrictions.eq("username",username ));
		List list = crit.list();
		s.close();
		Iterator itr = list.iterator();
		User user = new User ();
		
		while (itr.hasNext()) {
			user = (User) itr.next();}
		
		
		
		return user;
		
		
		}

}
