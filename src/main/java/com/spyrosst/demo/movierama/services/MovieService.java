package com.spyrosst.demo.movierama.services;

import java.util.List;

import com.spyrosst.demo.movierama.domain.Movie;
import com.spyrosst.demo.movierama.domain.MovieView;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie findMovieById(Long id);

	void createMovie(Movie movie);

	void deleteAllMovies();

	List<MovieView> getMoviesAggregatedByOpinionsOrderByPublishedDateDesc();

	List<MovieView> getMoviesAggregatedByOpinionsOrderByLikesDesc();

	List<MovieView> getMoviesAggregatedByOpinionsOrderByDislikesDesc();
	
	List<MovieView> getMoviesByName(String firstName, String familyName);

}
