package com.kasun.data;

public class Document {
	private String username;
	private String password;
	
	public Document(){
		
	}

	public Document(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void display(){
		System.out.println("Username : "+this.username);
		System.out.println("Password : "+this.password);
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
}
