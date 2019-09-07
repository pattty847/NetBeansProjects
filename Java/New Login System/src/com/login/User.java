package com.login;

public class User {

	private String username, password, email;
	boolean type = false;
	
	public User(String user, String password, String email, boolean type) {
		this.username = user;
		this.password = password;
		this.type = type;
		this.email = email;
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

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return username + "\n" + password + "\n" + email + "\n" + type + "\n"; 
	}


	public String getEmail() {
		return email;
	}

	
	
}
