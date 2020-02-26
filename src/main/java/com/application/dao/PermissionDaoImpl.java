package com.application.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.application.entity.Permission;

@Repository
@Transactional
public class PermissionDaoImpl implements PermissionDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Permission> getPermissions() {
		Session session=sessionFactory.openSession();
		Query<Permission> query = session.createQuery("From Permission",Permission.class);
		List<Permission> permissionList = query.getResultList();
		return permissionList;
	}
	
	public List<Permission> getPermissionsForIds(List<Integer> permissionIds)
	{
		Session session = sessionFactory.openSession();
		Query<Permission> query = session.createQuery("from Permission where permissionId in (:ids)",Permission.class);
		query.setParameterList("ids", permissionIds);
		List<Permission> permissionList = query.getResultList();
		return permissionList;
	}
}
