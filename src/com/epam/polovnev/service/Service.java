package com.epam.polovnev.service;

import com.epam.polovnev.rep.Repository;
import com.epam.polovnev.user.User;

public class Service {
	
	private Repository repository = new Repository();
	
	public boolean checkEmail(String email) {
		for (User u : repository.getUsers()) {
			if (u.getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}
	
	public void addUser(User user) {
		repository.getUsers().add(user);
	}
}
