package model;

import java.io.Serializable;

public class Account implements Serializable {
	private String username;
	private String password;
	private String lastname;
	private boolean role;
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String username, String password, String lastname, boolean role) {
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
}
