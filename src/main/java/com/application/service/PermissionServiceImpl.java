package com.application.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.PermissionDao;
import com.application.dao.RoleDao;
import com.application.entity.Permission;
import com.application.jtable.role.Option;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionDao permissionDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Permission> getPermission() {
		return permissionDao.getPermissions();
	}

	@Override
	public List<Option> getPermissionOption(List<Permission> permissionList) {
		List<Option> optionList = new ArrayList<Option>();
		if(null != permissionList && !permissionList.isEmpty())
		{
			Iterator<Permission> itr = permissionList.iterator();
			while(itr.hasNext())
			{
				Permission permission = itr.next();
				
				optionList.add(new Option(permission.getPermissionId().toString(),permission.getPermissionName()));
			}
		}
		return optionList;
	}

}
