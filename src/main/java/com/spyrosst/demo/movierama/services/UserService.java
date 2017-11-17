package com.spyrosst.demo.movierama.services;

import com.spyrosst.demo.movierama.domain.User;

public interface UserService {
	
	User findUserByUsername(String username);
	
	void saveUser(User user);
	
	void deleteAllUsers();

}
