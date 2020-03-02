package com.application.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<User> getUsers(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT r FROM User r");//SELECT o FROM Order o JOIN FETCH o.items i WHERE o.id
        query.setFirstResult(jtStartIndex);
        query.setMaxResults(jtPageSize);
        List<User> list = query.getResultList();
//        for(User u : list)
//        {
//        	u.getRole().size();
//        }
        session.getTransaction().commit();
        session.close();
		return  list;
	}

	@Override
	public void deleteUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
		
	}	
	
	@Override
	public User getUserById(Long userId)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, userId);
		tx.commit();
		session.close();
		return user;
	}
}
