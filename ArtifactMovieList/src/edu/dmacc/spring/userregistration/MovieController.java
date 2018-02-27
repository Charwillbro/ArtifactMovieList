package edu.dmacc.spring.userregistration;
//Charles Broderick
//Charwillbro@gmail.com
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	@Autowired
	MovieDao dao;

	private static final String[] rating = { "G", "PG", "PG-13", "NC-17", "R" };

	@RequestMapping(value = "/form")
	public ModelAndView movie() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("movieForm");
		modelAndView.addObject("movie", new Movie());
		modelAndView.addObject("rating", rating);

		return modelAndView;
	}

	@RequestMapping(value = "/result")
	public ModelAndView processMovie(Movie movie) {
		System.out.println("In processMovie");
		ModelAndView modelAndView = new ModelAndView();
		dao.insertMovie(movie);
		System.out.println("Value in getMovieTitle" + movie.getMovieTitle());
		modelAndView.setViewName("movieResult");
		modelAndView.addObject("u", movie);
		return modelAndView;
	}

	@RequestMapping(value = "/viewAll")
	public ModelAndView viewAll() {
		ModelAndView modelAndView = new ModelAndView();
		List<Movie> allMovies = dao.getAllMovies();
		modelAndView.setViewName("viewAllMovies");
		modelAndView.addObject("all", allMovies);
		return modelAndView;
	}

	@Bean
	public MovieDao dao() {
		MovieDao bean = new MovieDao();
		return bean;
	}

}