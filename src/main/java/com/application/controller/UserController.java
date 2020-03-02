package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.entity.User;
import com.application.jtable.role.Json;
import com.application.jtable.role.JsonResult;
import com.application.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String users() {
		return "users";
	}
	
	@RequestMapping(value = "/profile")
	public ModelAndView profile()
	{
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String uname = userDetails.getUsername();
		User user = userService.getUser(uname);
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("userprofile");
		return model;
	}
	
	@RequestMapping(value = "/userList")
	@ResponseBody
	public JsonResult<User> roleList(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {
		try {
			// Get data from database
			List<User> users = userService.getUsers(jtStartIndex, jtPageSize, jtSorting);
			int roleCount = users.size();
			return new Json<User>("OK", users, roleCount);

		} catch (Exception e) {
			return new Json<User>("ERROR", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<User> updateUser(User user) {
		try {
			 user = userService.updateUser(user);
			return new Json<User>("OK", user);
		} catch (Exception e) {
			return new Json<User>("ERROR", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<User> deleteRole(User user) {
		try {
			userService.deleteUser(user);
			return new Json<User>("OK", user);
		} catch (Exception e) {
			return new Json<User>("ERROR", e.getMessage());
		}
	}

}
