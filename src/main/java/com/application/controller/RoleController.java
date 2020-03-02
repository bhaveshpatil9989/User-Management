package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.Permission;
import com.application.entity.Role;
import com.application.jtable.role.Json;
import com.application.jtable.role.JsonResult;
import com.application.jtable.role.Option;
import com.application.service.RoleService;
import com.application.service.UserService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String roles() {
		return "roles";
	}

	@RequestMapping(value = "/roleList")
	@ResponseBody
	public JsonResult<Role> roleList(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {
		try {
			// Get data from database
			List<Role> roles = roleService.getRoles(jtStartIndex, jtPageSize, jtSorting);
			int roleCount = roles.size();
			return new Json<Role>("OK", roles, roleCount);

		} catch (Exception e) {
			return new Json<Role>("ERROR", e.getMessage());
		}
	}

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Role> addRole(Role role) {
		try {
			roleService.saveRole(role);
			return new Json<Role>("OK", role);
		} catch (Exception e) {
			return new Json<Role>("ERROR", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Role> updateRole(Role role) {
		try {
			roleService.updateRole(role);
			return new Json<Role>("OK", role);
		} catch (Exception e) {
			return new Json<Role>("ERROR", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Role> deleteRole(Role role) {
		try {
			roleService.deleteRole(role);
			return new Json<Role>("OK", role);
		} catch (Exception e) {
			return new Json<Role>("ERROR", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/userRoles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResult<Option> getRoleForTable() {
		try {
			List<Option> options = roleService.getRoleOption(roleService.getAllRoles());
			return new Json<Option>("OK", options);
		} catch (Exception ex) {
			return new Json<Option>("ERROR", ex.getMessage());
		}
	}

	@RequestMapping(value = "/userRoleforUser",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResult<Option> getRolesForUser(@RequestParam("username") String username) {
		
		try {
			Role r = userService.getUser(username).getRole();
			List<Role> roleList = new ArrayList<>();
			roleList.add(r);
			List<Option> options = roleService.getRoleOption(roleList);
			return new Json<Option>("OK", options);
		} catch (Exception ex) {
			return new Json<Option>("ERROR", ex.getMessage());
		}
	}
	
	
	
	
	
}
