package com.spyrosst.demo.movierama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spyrosst.demo.movierama.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
