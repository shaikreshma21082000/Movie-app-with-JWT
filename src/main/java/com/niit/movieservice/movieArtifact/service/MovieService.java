package com.niit.movieservice.movieArtifact.service;

import com.niit.movieservice.movieArtifact.model.Movie;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie) ;
    List<Movie> getAllMovies();
    Movie updateMovie(Movie movie, String movieName);
    boolean deleteMovieByMovieId(int movieId);
    List<Movie> getMovieByMovieName(String movieName);
}
