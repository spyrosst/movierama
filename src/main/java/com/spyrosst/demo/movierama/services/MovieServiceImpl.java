package com.spyrosst.demo.movierama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spyrosst.demo.movierama.domain.Movie;
import com.spyrosst.demo.movierama.domain.MovieView;
import com.spyrosst.demo.movierama.repositories.MovieRepository;
import com.spyrosst.demo.movierama.repositories.MovieViewRepository;

@Service
@Primary
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private MovieViewRepository movieViewRepo;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();

	}

	@Override
	public Movie findMovieById(Long id) {
		return movieRepo.findOne(id);

	}

	@Override
	@Transactional
	public void createMovie(Movie movie) {
		movieRepo.save(movie);

	}

	@Override
	@Transactional
	public void deleteAllMovies() {
		movieRepo.deleteAll();

	}

	@Override
	public List<MovieView> getMoviesAggregatedByOpinionsOrderByPublishedDateDesc() {
		Sort sort = new Sort(new Order(Direction.DESC, "published_date"));
		return movieViewRepo.findAll(sort);
	}

	@Override
	public List<MovieView> getMoviesAggregatedByOpinionsOrderByLikesDesc() {
		Sort sort = new Sort(new Order(Direction.DESC, "likes"), new Order(Direction.ASC, "dislikes"));
		return movieViewRepo.findAll(sort);
	}

	@Override
	public List<MovieView> getMoviesAggregatedByOpinionsOrderByDislikesDesc() {
		Sort sort = new Sort(new Order(Direction.DESC, "dislikes"), new Order(Direction.ASC, "likes"));
		return movieViewRepo.findAll(sort);
	}

	@Override
	public List<MovieView> getMoviesByName(String firstName, String familyName) {
		return movieViewRepo.findByFirstNameAndLastName(firstName, familyName);
	}

}
