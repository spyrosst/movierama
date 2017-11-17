package com.spyrosst.demo.movierama.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spyrosst.demo.movierama.domain.User;
import com.spyrosst.demo.movierama.repositories.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional
	public void saveUser(User user) {
		userRepo.save(user);
	}

	@Override
	@Transactional
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	

}
