package com.logger.Group1RoomServiceSys.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.logger.Group1RoomServiceSys.beans.UserRole;

import lombok.Data;

@Entity
@Data
@Table(name="USERS")
public class User implements UserDetails {
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column(name="CELLPHONE")
	private String cellphone;
	
	@Column(name="EMAIL")
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			// Join table name
			name = "USER_AND_USERROLE",	
			// define how join table will join with the current table
			joinColumns = {
					@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
			},
			// define how join table will join with the other table		
			inverseJoinColumns = {
					@JoinColumn(name = "USER_ROLE_ID", referencedColumnName = "ID")
			}
	)
	private List<UserRole> role = new ArrayList<UserRole>();

	public User() {
		super();
	}
	
	public User(int id, String name, String password, String cellphone, String email, List<UserRole> role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.role = role;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return name;
	}

}
