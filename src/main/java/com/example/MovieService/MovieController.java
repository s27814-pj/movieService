package com.example.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Otrzmyaj filmy", description = "Wyświela listy wszystkich filmów w bazie danych")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovieList(){
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @Operation(summary = "Pokaz film", description = "Wyświela film o podanym id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "nie ma filmu o tym id")
    })
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(required = true) int id){
        return ResponseEntity.of(movieService.findMovieById(id));
    }

//    @PostMapping("/movies")
//    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
//        return ResponseEntity.ok(movieService.addMovie((new Movie(5L,movie.getName(),movie.getCategory()))));
//        //return ResponseEntity.of(movieService.findMovieById(1));
//    }


    @Operation(summary = "dodaj film", description = "dodaje film o podanych wartosciach w POST i  zwraca go przy sukcesie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "film dodany")
    })
    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(new Movie(0L, movie.getName(), movie.getCategory())));
    }

    @Operation(summary = "aktualizuj film", description = "aktualizuje film z id o podane wartosci i zwraca go przy sukcesie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "film zaktualizowany"),
            @ApiResponse(responseCode = "404", description = "nie znaleziono filmu do aktualiacji")
    })
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable(required = true) int id){
        return ResponseEntity.ok(movieService.updateMovie(movie,id));
    }
    @Operation(summary = "usun film", description = "usun film z id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "film usuniety"),
            @ApiResponse(responseCode = "404", description = "nie znaleziono filmu do aktualiacji")
    })
    @DeleteMapping("movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable(required = true) @Parameter(name = "id", description = "id filmu w bazie", example = "1") int id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "film avaiblity ustaw na true", description = "film avaiblity ustaw na true")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "film ma true"),
            @ApiResponse(responseCode = "404", description = "nie znaleziono filmu do aktualiacji")
    })
    @PutMapping("/setTrue/{id}")
    public ResponseEntity<Movie> setTrue(@PathVariable int id){
    return ResponseEntity.ok(movieService.setTrue(id));
    }

    @Operation(summary = "film avaiblity ustaw na false", description = "film avaiblity ustaw na false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "film ma false"),
            @ApiResponse(responseCode = "404", description = "nie znaleziono filmu do aktualiacji")
    })
    @PutMapping("/setFalse/{id}")
    public ResponseEntity<Movie> setFalse(@PathVariable int id){
        return ResponseEntity.ok(movieService.setFalse(id));
    }

    @Operation(summary = "rzuca błędem 500", description = "rzuca błędem 500")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "rzuca błędem 500"),
    })
    @GetMapping("/throw500")
    public ResponseEntity<Exception> throw500(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
