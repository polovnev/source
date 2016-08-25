package com.epam.polovnev.user;

import java.util.*;

public class User {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private boolean isSendMessage;
		
	
	public User(String name, String surname, String email, String password,
			boolean isSendMessage) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.isSendMessage = isSendMessage;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isSendMessage() {
		return isSendMessage;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", surname=" + surname + ", email="
				+ email + ", password=" + password + ", isSendMessage="
				+ isSendMessage + "]";
	}
	
	
	
}
