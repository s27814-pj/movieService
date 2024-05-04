package com.example.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieStorage movieStorage;

    public MovieService(MovieStorage movieStorage){
        this.movieStorage = movieStorage;
    }

    public List<Movie> getMovieList() {
        return movieStorage.getMovieList();
    }

    public Optional<Movie> findMovieById(int id){
        return movieStorage.findMovieById((long) id);
    }

    public Movie addMovie(Movie mov){
        movieStorage.addMovie(mov);
        return mov;
    }
}
