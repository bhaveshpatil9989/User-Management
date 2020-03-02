package com.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.dao.UserDao;
import com.application.entity.Permission;
import com.application.entity.Role;
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
		Role role = user.getRole();
		role.setPermissions(roleService.getRole(role.getRoleId()).getPermissions());
		
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
	
	public User getUser(String username)
	{
		User user = userDao.getUserbyUsername(username);
		return user;
	}

	@Override
	public List<User> getUsers(Integer jtStartIndex, Integer jtPageSize, String jtSorting) {
		List<User> userList = userDao.getUsers(jtStartIndex, jtPageSize, jtSorting);
		userList = userList.stream().map(this::mapRoleToRoleId).collect(Collectors.toList());
		return userList;
	}

	@Override
	public User updateUser(User user) {
		User dbUser = userDao.getUserById(user.getId());
		Role role = roleService.getRole(user.getRoleId());
		dbUser.setRole(role);
		dbUser.setRoleId(role.getRoleId());
		userDao.saveUser(dbUser);
		return dbUser;
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	public User mapRoleToRoleId(User u) {
		u.setRoleId(u.getRole().getRoleId());
		return u;
	}
	
	

}
