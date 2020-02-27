package com.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.dao.UserDao;
import com.application.entity.User;
import com.application.entity.UserDetailsImpl;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.getUserbyUsername(username);
		UserDetails userDetails = new UserDetailsImpl(user);
		return userDetails;
	} 

	@Override
	public void saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		if(user.getRole()==null)
		{
			user.setRole(roleService.getDefaultRole());
		}
		
		userDao.saveUser(user);
	}
	
	

}
