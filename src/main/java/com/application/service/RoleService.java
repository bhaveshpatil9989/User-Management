package com.application.service;

import java.util.List;

import com.application.entity.Role;
import com.application.jtable.role.Option;

public interface RoleService {

	public void saveRole(Role role);
	
	public List<Role> getRoles(Integer jtStartIndex, Integer jtPageSize, String jtSorting);
	
	public void updateRole(Role role);
	
	public Role getRole(Integer roleId);
	
	public Role getDefaultRole();
	
	public void deleteRole(Role role);
	
	public List<Option> getRoleOption(List<Role> roleList);
	
	public List<Role> getAllRoles();
	
}
