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
    private final MovieRepository movieRepository;

    public MovieService(MovieStorage movieStorage, MovieRepository movieRepository) {
        this.movieStorage = movieStorage;
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieList() {
        return movieRepository.findAllByIdIsNotNull();
        //return movieRepository.findAll();
        //return movieStorage.getMovieList();
    }

    public Optional<Movie> findMovieById(int id) {
        return movieRepository.findMovieById((long)id);
        //return movieRepository.findById((long) id);
        //return movieStorage.findMovieById((long) id);
    }

    public Movie addMovie(Movie mov) {
        return movieRepository.save(mov);
        //movieStorage.addMovie(mov);
        //return mov;
    }

    public Movie updateMovie(Movie mov, int id) {
        //Movie tmp = findMovieById(id)
        Movie tmp = movieRepository.findById((long)id)
                .orElseThrow(() -> new NoSuchElementException("no movie with " + id));
        tmp.setCategory(mov.getCategory());
        tmp.setName(mov.getName());
        return movieRepository.save(tmp);
        //return movieStorage.updateMovie(tmp, mov);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById((long)id);
        //movieStorage.deleteMovie(id);
    }
    public Movie setTrue(int id){
        Movie tmp = movieRepository.findById((long)id)
                .orElseThrow(() -> new NoSuchElementException("no movie with " + id));
        tmp.setAvailable(true);
        return movieRepository.save(tmp);
    }
    public Movie setFalse(int id){
        Movie tmp = movieRepository.findById((long)id)
                .orElseThrow(() -> new NoSuchElementException("no movie with " + id));
        tmp.setAvailable(false);
        return movieRepository.save(tmp);
    }
}
