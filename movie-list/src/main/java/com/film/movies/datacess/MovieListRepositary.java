package com.film.movies.datacess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.film.movies.model.Movie;

public interface MovieListRepositary extends JpaRepository<Movie, Long> {
	
	List<Movie>	findMoviesByName(String name);
	
}
