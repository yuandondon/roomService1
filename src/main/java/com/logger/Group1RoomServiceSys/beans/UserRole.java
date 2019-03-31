package com.logger.Group1RoomServiceSys.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;


@Entity
@Data
@Table(name="USER_ROLES")
public class UserRole implements GrantedAuthority {
	
	@Id
	private int id;
	@Column(name="ROLE_TYPE")
	private String role;
	public UserRole() {
		super();
	}
	public UserRole(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}
	
}
