package com.application.service;

import java.util.List;

import com.application.entity.Role;

public interface RoleService {

	public void saveRole(Role role);
	
	public List<Role> getRoles(Integer jtStartIndex, Integer jtPageSize, String jtSorting);
	
	public void updateRole(Role role);
	
	public Role getRole(Integer roleId);
	
	public Role getDefaultRole();
	
}
