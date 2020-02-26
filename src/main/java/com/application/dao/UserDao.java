package com.application.dao;

import com.application.entity.User;

public interface UserDao {

	public User getUserbyUsername(String username);
	
	public void saveUser(User user);
}
