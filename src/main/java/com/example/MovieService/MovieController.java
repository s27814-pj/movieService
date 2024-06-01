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

//    @PostMapping("/movies")
//    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
//        return ResponseEntity.ok(movieService.addMovie((new Movie(5L,movie.getName(),movie.getCategory()))));
//        //return ResponseEntity.of(movieService.findMovieById(1));
//    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(new Movie(0L, movie.getName(), movie.getCategory())));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable(required = true) int id){
        return ResponseEntity.ok(movieService.updateMovie(movie,id));
    }

    @DeleteMapping("movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable(required = true) int id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/setTrue/{id}")
    public ResponseEntity<Movie> setTrue(@PathVariable int id){
    return ResponseEntity.ok(movieService.setTrue(id));
    }

    @GetMapping("/setFalse/{id}")
    public ResponseEntity<Movie> setFalse(@PathVariable int id){
        return ResponseEntity.ok(movieService.setFalse(id));
    }
}
