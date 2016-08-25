package com.epam.polovnev.rep;

import java.util.ArrayList;
import java.util.List;

import com.epam.polovnev.user.User;

public class Repository {
	private List<User> users = new ArrayList<User>() {
		{
			add(new User("Vasya", "Kok", "blabla@mail.ru", "12345", true));
			add(new User("Gora", "Ivanov", "asdgf@gmail.com",
					"123qwe12345", false));
			add(new User("Nikita", "Sidorov", "asdnf@rambler.ru",
					"qwerfds12345", true));
		}
	};

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
