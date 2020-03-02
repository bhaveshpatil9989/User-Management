package com.application.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.PermissionDao;
import com.application.dao.RoleDao;
import com.application.entity.Permission;
import com.application.entity.Role;
import com.application.jtable.role.Option;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Autowired
	PermissionDao permissionDao;

	private static final Integer DEFAULT_ROLE = new Integer(28);

	@Override
	public void saveRole(Role role) {
		List<Integer> permissionIds = role.getPermissionId();
		List<Permission> permissionList = permissionDao.getPermissionsForIds(permissionIds);
		role.setPermissions(new HashSet<Permission>(permissionList));
		roleDao.saveRole(role);
	}

	@Override
	public List<Role> getRoles(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {
		List<Role> roleList = roleDao.getRoles(jtStartIndex, jtPageSize, jtSorting);

		roleList = roleList.stream().map(this::populatePermissionIds).collect(Collectors.toList());
		return roleList;
	}

	public Role populatePermissionIds(Role r) {
		List<Integer> permissionIdList = r.getPermissions().stream().map(p -> p.getPermissionId())
				.collect(Collectors.toList());
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

	@Override
	public Role getDefaultRole() {
		return getRole(DEFAULT_ROLE);
	}
	
	@Override
	public void deleteRole(Role role)
	{
		roleDao.deleteRole(role);
	}
	
	@Override
	public List<Option> getRoleOption(List<Role> roleList) {
		List<Option> optionList = new ArrayList<Option>();
		if(null != roleList && !roleList.isEmpty())
		{
			Iterator<Role> itr = roleList.iterator();
			while(itr.hasNext())
			{
				Role role = itr.next();
				
				optionList.add(new Option(role.getRoleId().toString(),role.getRoleName()));
			}
		}
		return optionList;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}
}
