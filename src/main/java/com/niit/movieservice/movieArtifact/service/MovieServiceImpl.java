package com.niit.movieservice.movieArtifact.service;

import com.niit.movieservice.movieArtifact.model.Movie;
import com.niit.movieservice.movieArtifact.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        System.out.println("inside get movies service");
        List<Movie> list=movieRepository.findAll();
        list.forEach((n) -> System.out.println(n.toString()));
        return list;
    }

    @Override
    public Movie updateMovie(Movie movie, String movieName) {

        if(movieRepository.findByMovieName(movieName).isEmpty())
        {
            return null;
        }
        return movieRepository.save(movie);
    }

    @Override
    public boolean deleteMovieByMovieId(int movieId) {
        movieRepository.deleteById(movieId);
        return true;
    }

    @Override
    public List<Movie> getMovieByMovieName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }
}
