package com.application.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.PermissionDao;
import com.application.dao.RoleDao;
import com.application.entity.Permission;
import com.application.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PermissionDao permissionDao;

	@Override
	public void saveRole(Role role) {
		
		roleDao.saveRole(role);
	}

	@Override
	public List<Role> getRoles(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {
		List<Role> roleList = roleDao.getRoles(jtStartIndex, jtPageSize, jtSorting);
		
		roleList = roleList.stream().map(this::populatePermissionIds).collect(Collectors.toList());
		return roleList;
	}
	
	public Role populatePermissionIds(Role r)
	{
		List<Integer> permissionIdList = r.getPermissions().stream().map(p->p.getPermissionId()).collect(Collectors.toList());
		r.setPermissionId(permissionIdList);
		return r;
	}

	@Override
	public void updateRole(Role role) {
		List<Integer> permissionIds = role.getPermissionId();
		List<Permission> permissionList = permissionDao.getPermissionsForIds(permissionIds);
		role.setPermissions(new HashSet<Permission>(permissionList));
		roleDao.saveRole(role);
		
	}

	@Override
	public Role getRole(Integer roleId) {
		return roleDao.getRole(roleId);
	}
	
	

}
