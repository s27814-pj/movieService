package com.example.MovieService;

import org.springframework.stereotype.Component;

import java.util.*;

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
        if ((mov.getCategory()==null) || (mov.getName() ==null)) throw new IllegalArgumentException("cat and name required");
        movieList.add(mov);
        return mov;
    }

    public Movie updateMovie(Movie oldMov, Movie newMov){
        oldMov.setCategory(newMov.getCategory());
        oldMov.setName(newMov.getName());
        return oldMov;
    }

    public void deleteMovie(int id){
        //movieList.removeIf(movie -> movie.getId().equals((long) id));
        boolean wasDeleted=false;
        Iterator<Movie> iterator = movieList.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals((long)id)){
                iterator.remove();
                wasDeleted=true;
                break;
            }
        }
        if (!wasDeleted) throw new NoSuchElementException("no movie with " + id);
    }

}
