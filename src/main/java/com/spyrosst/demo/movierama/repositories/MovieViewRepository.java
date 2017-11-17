package com.spyrosst.demo.movierama.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spyrosst.demo.movierama.domain.MovieView;

public interface MovieViewRepository extends JpaRepository<MovieView, Long> {

	List<MovieView> findByFirstNameAndLastName(String firstName, String familyName);
	
	List<MovieView> findByPublishedByUserId(Long userId);
}
