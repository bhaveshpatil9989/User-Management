package com.application.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private String password;
	
	private String username;
	
	private User user;
	
	public UserDetailsImpl(User user)
	{
		this.username =  user.getUsername();
		this.password = user.getPassword();
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		if (user == null) {
			throw new IllegalArgumentException();
		}
		final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		final List<Permission> permissions = new ArrayList<>(user.getRole().getPermissions());
		if ((permissions != null) && (!permissions.isEmpty())) {
			for (int i = 0; i < permissions.size(); i++) {
				final Permission permission = permissions.get(i);
				final GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermissionName());
				grantedAuthorities.add(authority);
			}
		}
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
