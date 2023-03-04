package com.pro.soccer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Column(nullable=false)
	private String name;
	
	@Id
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	private String password;

	
	private String roles ;

	public Users() {
		super();
		
	}
	public Users(String name, String email, String password, String roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User =" + name + ", email=" + email + ", password=" + password + ", roles=" + roles
				+ "]";
	}
}
