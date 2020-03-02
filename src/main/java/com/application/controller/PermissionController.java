package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.Permission;
import com.application.jtable.role.Json;
import com.application.jtable.role.JsonResult;
import com.application.jtable.role.Option;
import com.application.service.PermissionService;
import com.application.service.RoleService;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	
	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Permission> getPermission() {
		return permissionService.getPermission();
	}

	@RequestMapping(value = "/rolePermissions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResult<Option> getPermissionForTable() {
		try {
			List<Option> options = permissionService.getPermissionOption(permissionService.getPermission());
			return new Json<Option>("OK", options);
		} catch (Exception ex) {
			return new Json<Option>("ERROR", ex.getMessage());
		}
	}

	@RequestMapping(value = "/rolePermissionsForRole",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResult<Option> getPermissionsForRole(@RequestParam("roleId") Integer roleId) {
		
		try {
			List<Permission> permissionList = new ArrayList<>(roleService.getRole(roleId).getPermissions());
			List<Option> options = permissionService.getPermissionOption(permissionList);
			return new Json<Option>("OK", options);
		} catch (Exception ex) {
			return new Json<Option>("ERROR", ex.getMessage());
		}
	}

}