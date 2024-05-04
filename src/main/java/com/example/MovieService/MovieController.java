package com.example.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovieList(){
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(required = true) int id){
        return ResponseEntity.of(movieService.findMovieById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie((new Movie(5L,movie.getName(),movie.getCategory()))));
        //return ResponseEntity.of(movieService.findMovieById(1));
    }
}
