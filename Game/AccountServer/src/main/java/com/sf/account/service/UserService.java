package com.sf.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.account.bean.User;
import com.sf.account.dao.UserDao;

@Component
public class UserService {
	@Autowired
	private UserDao usermapper;
	
	public boolean registerUser(User user) {
		Integer result = usermapper.addUser(user);
		return result != null && result  == 1;
	}
	
	public User login(String name) {
		User user = usermapper.selectUser(name);
		return user;
	}
	
	public User getUserByName(String name){
		User user = usermapper.selectUserByName(name);
		return user;
	}
	
}
