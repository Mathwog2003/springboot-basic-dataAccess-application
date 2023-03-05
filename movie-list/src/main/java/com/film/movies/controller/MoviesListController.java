package com.film.movies.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.film.movies.datacess.MovieListRepositary;
import com.film.movies.model.Movie;

@Controller
@RequestMapping("/")
public class MoviesListController {

	@Autowired
	private MovieListRepositary movieListRepositary;
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/{actor}")
	public String getMovieList(@PathVariable("actor") String name,Model model) {
		/*	List<Movie> movieList = new ArrayList<Movie>();
		Movie movie = new Movie();
		
		movie.setActor("tom");
		movie.setDescription("thriller movie");
		movie.setName("final death");
		movieList.add(movie); */
		
		List<Movie> movieList =	movieListRepositary.findMoviesByName(name);
		
		model.addAttribute("movies",movieList);
		
		return "movies";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/movies", consumes="application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie)
	{
		movieListRepositary.save(movie);
		return ResponseEntity.ok().build();
	}
}
