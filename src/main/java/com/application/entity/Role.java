package com.application.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "description")
	private String description;
	
	@Transient
	private List<Integer> permissionId;
	
	
	public List<Integer> getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(List<Integer> permissionId) {
		this.permissionId = permissionId;
	}
	@JsonIgnore
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="role_permission",
		joinColumns= {@JoinColumn(name="role_id")},
		inverseJoinColumns= {@JoinColumn(name="permission_id")})
	private Set<Permission> permissions;

	@JsonIgnore
	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	@JsonProperty("permissions")
	@JsonDeserialize(as = HashSet.class, contentAs = Permission.class)
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	
}
