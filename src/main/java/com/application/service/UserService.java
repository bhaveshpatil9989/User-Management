package com.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.application.entity.User;

public interface UserService extends  UserDetailsService {
	
	public void saveUser(User user); 
} 