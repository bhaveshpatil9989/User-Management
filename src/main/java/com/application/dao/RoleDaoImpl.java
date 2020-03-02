package com.application.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.application.entity.Permission;
import com.application.entity.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveRole(Role role)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(role);
		tx.commit();
		session.close();
	}

	@Override
	public List<Role> getRoles(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT r FROM Role r left JOIN FETCH r.permissions");//SELECT o FROM Order o JOIN FETCH o.items i WHERE o.id
        query.setFirstResult(jtStartIndex);
        query.setMaxResults(jtPageSize);
        List<Role> list = query.getResultList();
        for(Role r : list)
        {
        	r.getPermissions().size();
        }
        session.close();
		return  list;
	}
	
	@Override
	public Role getRole(Integer roleId)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT r FROM Role r LEFT JOIN FETCH r.permissions WHERE r.roleId=:rid");
		query.setParameter("rid", roleId);
        List<Role> list = query.getResultList();
		//Role role = session.get(Role.class, roleId);
        if(!list.isEmpty())
        {
        		list.get(0).getPermissions();
        }
        session.close();
		return list.isEmpty()?null:list.get(0);
	}
	
	@Override
	public void deleteRole(Role role)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(role);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<Role> getAllRoles() {
		Session session=sessionFactory.openSession();
		Query<Role> query = session.createQuery("From Role",Role.class);
		List<Role> roleList = query.getResultList();
		session.close();
		return roleList;
	}
}