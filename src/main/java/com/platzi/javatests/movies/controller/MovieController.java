package com.platzi.javatests.movies.controller;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import com.platzi.javatests.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Collection<Movie> getMovies(@RequestParam(required = false) Genre genre) {

        if (genre == null) {
            return movieService.findAll();
        } else {
            return movieService.findMoviesByGenre(genre);
        }
    }
}
