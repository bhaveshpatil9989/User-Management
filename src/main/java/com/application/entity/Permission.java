package com.application.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="permission")
public class Permission {

	@Id
	@Column(name="permission_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("permissionId")
	private Integer permissionId;
					
	@Column(name="permission_name")
	private String  permissionName;
	
	@Column(name="description")
	private String description;
	
	
	public Permission() {
		super();
	}

	public Permission(Integer permissionId) {
		super();
		this.permissionId = permissionId;
	}

	@JsonIgnore
	 @ManyToMany(mappedBy = "permissions")
//	@JoinTable(name="role_permission",
//		joinColumns=@JoinColumn(name="permission_id"),
//		inverseJoinColumns= @JoinColumn(name="role_id"))
	Set<Role> role;
	

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
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
		result = prime * result + ((permissionId == null) ? 0 : permissionId.hashCode());
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
		Permission other = (Permission) obj;
		if (permissionId == null) {
			if (other.permissionId != null)
				return false;
		} else if (!permissionId.equals(other.permissionId))
			return false;
		return true;
	}
	
	
}
