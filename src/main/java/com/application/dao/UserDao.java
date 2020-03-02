package com.application.dao;

import java.util.List;

import com.application.entity.User;

public interface UserDao {

	public User getUserbyUsername(String username);
	
	public void saveUser(User user);
	
	public List<User> getUsers(Integer jtStartIndex, Integer jtPageSize, String jtSorting);
	
	public void deleteUser(User user);
	
	public User getUserById(Long userId);
}
