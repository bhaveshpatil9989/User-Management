package com.application.dao;

import java.util.List;

import com.application.entity.Permission;

public interface PermissionDao {

	public List<Permission> getPermissions();
	
	public List<Permission> getPermissionsForIds(List<Integer> permissionIds);
	
}
