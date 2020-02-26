package com.application.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.application.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserbyUsername(String username) {
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery("From User where username = :uname",User.class);
		query.setParameter("uname", username);
		List<User> users = query.list();
		session.close();
		if(!users.isEmpty())
			return users.get(0);
		else
			return new User();
	}
 
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
		
	}	
}
