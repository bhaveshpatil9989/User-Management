package com.application.service;

import java.util.List;

import com.application.entity.Permission;
import com.application.jtable.role.Option;

public interface PermissionService {
	
	public List<Permission> getPermission();
	
	public List<Option> getPermissionOption(List<Permission> permissionList);
}
