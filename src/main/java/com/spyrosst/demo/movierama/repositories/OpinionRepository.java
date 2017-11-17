package com.spyrosst.demo.movierama.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spyrosst.demo.movierama.domain.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
	
	List<Opinion> findByPostedByUserId(Long userId);

}
	