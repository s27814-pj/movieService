package com.example.MovieService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MovieStorage {

    private List<Movie> movieList;

    public MovieStorage(){
        Movie mov1 = new Movie( 1L,"nazwa","kategoria");
        Movie mov2 = new Movie( 11L,"nazwa2","kategoria2");
        this.movieList=new ArrayList<Movie>();
        this.movieList.add(mov1);
        this.movieList.add(mov2);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
    public Optional<Movie> findMovieById(Long id){
        return getMovieList().stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();

    }

    public Movie addMovie(Movie mov){
        movieList.add(mov);
        return mov;
    }

}
