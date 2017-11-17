package com.spyrosst.demo.movierama.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spyrosst.demo.movierama.domain.MovieView;
import com.spyrosst.demo.movierama.services.MovieService;

@Controller
public class MoviesController {

	@Autowired
	private MovieService movieService;

	@RequestMapping("/")
	public String movies(Model model) {
		List<MovieView> movies = movieService.getMoviesAggregatedByOpinionsOrderByPublishedDateDesc();
		model.addAttribute("movies", movies);
		return "index";
	}

	@RequestMapping("/likes")
	public String moviesOrderByLikes(Model model) {
		List<MovieView> movies = movieService.getMoviesAggregatedByOpinionsOrderByLikesDesc();
		model.addAttribute("movies", movies);
		return "index";
	}

	@RequestMapping("/dislikes")
	public String moviesOrderByDislikes(Model model) {
		List<MovieView> movies = movieService.getMoviesAggregatedByOpinionsOrderByDislikesDesc();
		model.addAttribute("movies", movies);
		return "index";
	}

	@RequestMapping("/user/{id}")
	public String moviesFindByName(@PathVariable("id") Long id, Model model) {
		List<MovieView> movies = movieService.getMoviesByUserId(id);
		model.addAttribute("movies", movies);
		return "index";
	}

}
