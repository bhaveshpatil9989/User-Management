package com.application.dao;

import java.util.List;

import com.application.entity.Role;

public interface RoleDao {
	
	public void saveRole(Role role);
	
	public List<Role> getRoles(Integer jtStartIndex, Integer jtPageSize, String jtSorting);
	
	public Role getRole(Integer roleId);

}
