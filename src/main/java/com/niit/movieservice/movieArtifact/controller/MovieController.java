package com.niit.movieservice.movieArtifact.controller;

import com.niit.movieservice.movieArtifact.model.Movie;
import com.niit.movieservice.movieArtifact.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class MovieController {
    private MovieService movieService;

    @Autowired
    MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @CrossOrigin(origins="http://localhost:9000")
    @PostMapping("/api/v1/movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies() {
        System.out.println("inside get movies controller");
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.FOUND);
    }

    @GetMapping("/api/v1/movie/{movieName}")
    public ResponseEntity<?> getAllMovieByMovieName(@PathVariable String movieName) {
        return new ResponseEntity<>(movieService.getMovieByMovieName(movieName), HttpStatus.FOUND);
    }

    @DeleteMapping("/api/v1/delete-movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable int movieId){
        return new ResponseEntity<>(movieService.deleteMovieByMovieId(movieId), HttpStatus.OK);
    }

    @PutMapping("/api/v1/movies/{movieName}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie,@PathVariable String movieName) {
        return new ResponseEntity<>(movieService.updateMovie(movie,movieName), HttpStatus.OK);
    }

}







