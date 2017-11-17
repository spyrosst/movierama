package com.spyrosst.demo.movierama;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spyrosst.demo.movierama.domain.Movie;
import com.spyrosst.demo.movierama.domain.MovieView;
import com.spyrosst.demo.movierama.domain.Opinion;
import com.spyrosst.demo.movierama.domain.User;
import com.spyrosst.demo.movierama.services.MovieService;
import com.spyrosst.demo.movierama.services.OpinionService;
import com.spyrosst.demo.movierama.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieramaApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(MovieramaApplicationTests.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private OpinionService opinionService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testInit() {
		loadTestData();
	}

	private void loadTestData() {

		// Clean up
		opinionService.deleteAllOpinions();
		movieService.deleteAllMovies();
		userService.deleteAllUsers();

		// Load test data
		// load users
		int noOfUsers = 10;
		for (int i = 1; i <= noOfUsers; i++) {
			User user = new User("username" + i, "FirstName" + i, "LastName" + i, "hashedPassword" + i);
			userService.saveUser(user);
		}
		// load movies
		for (int i = 1; i <= noOfUsers; i++) {
			for (int k = 1; k <= i; k++) {
				Movie movie = new Movie("Title-" + UUID.randomUUID(),
						"Description Description Description Description Description Description " + UUID.randomUUID(),
						userService.findUserByUsername("username" + i));
				movieService.createMovie(movie);
			}
		}
		// load opinions
		List<Movie> movies = movieService.getAllMovies();
		for (Movie movie : movies.subList(0, movies.size() - 10)) {
			for (int k = 1; k <= noOfUsers; k++) {
				User user = userService.findUserByUsername("username" + k);
				if (movie.getPublishedByUser().getId() != user.getId()) {
					Opinion opinion = new Opinion(new Random().nextBoolean() ? 1 : -1, movie, user);
					opinionService.manageOpinion(opinion);
				}
			}
		}
	}

	@Test
	public void getData() {
		// getMoviesAggregatedByOpinionsOrderByLikesDesc
		List<MovieView> moviesView = movieService.getMoviesAggregatedByOpinionsOrderByLikesDesc();
		for (MovieView view : moviesView) {
			logger.info("getMoviesAggregatedByOpinionsOrderByLikesDesc_" + view.toString());
		}
		// getMoviesByName
		List<MovieView> moviesView2 = movieService.getMoviesByName("FirstName4", "LastName4");
		for (MovieView view : moviesView2) {
			logger.info("getMoviesByName_" + view.toString());
		}
		// getAllOpinionsByUserId
		List<Opinion> userOpinions = opinionService
				.getAllOpinionsByUserId(userService.findUserByUsername("username8").getId());
		for (Opinion opinion : userOpinions) {
			logger.info("getAllOpinionsByUserId_" + opinion.toString());
		}

	}

}
