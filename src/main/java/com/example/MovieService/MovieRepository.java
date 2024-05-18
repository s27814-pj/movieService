package com.example.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieById (Long aLong);
    List<Movie> findAllByIdIsNotNull();
    //List<Movie> findAll();
}
