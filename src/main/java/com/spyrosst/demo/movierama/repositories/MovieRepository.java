package com.spyrosst.demo.movierama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spyrosst.demo.movierama.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
