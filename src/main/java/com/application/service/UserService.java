package com.application.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.application.entity.User;

public interface UserService extends  UserDetailsService {
	
	public void saveUser(User user); 
	
	public User getUser(String username);
	
	public List<User> getUsers(Integer jtStartIndex, Integer jtPageSize, String jtSorting);
	
	public User updateUser(User user);
	
	public void deleteUser(User user);
} 