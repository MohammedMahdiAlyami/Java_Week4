package com.example.project_4.Service;

import com.example.project_4.ApiException.ApiException;
import com.example.project_4.Model.Director;
import com.example.project_4.Model.Movie;
import com.example.project_4.Repository.DirectorRepository;
import com.example.project_4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        Director director = directorRepository.findDirectorById(movie.getDirectorid());
        if (director == null) {
            throw new ApiException("director not found");
        }
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie) {
        Movie oldMovie = movieRepository.findMovieById(id);
        if (oldMovie == null) {
            throw new ApiException("Movie not found");
        }
        Director director = directorRepository.findDirectorById(movie.getDirectorid());
        if (director == null) {
            throw new ApiException("director not found");
        }
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setDirectorid(movie.getDirectorid());
        movieRepository.save(oldMovie);
    }

    public void deleteMovie(Integer id) {
        Movie oldMovie = movieRepository.findMovieById(id);
        if (oldMovie == null) {
            throw new ApiException("Movie not found");
        }
        movieRepository.deleteById(id);
    }

    public Movie findMovieByTitle(String title) {
        Movie movie = movieRepository.findMovieByName(title);
        if (movie == null) {
            throw new ApiException("Movie with this title not found");
        }
        return movie;
    }

    public Integer getMovieDurationByTitle(String title) {
        Movie movie = movieRepository.findMovieByName(title);
        if (movie == null) {
            throw new ApiException("Movie with this title not found");
        }
        return movie.getDuration();
    }

    public Integer getMovieRate(String mName) {
        Movie movie = movieRepository.findMovieByName(mName);
        if (movie == null) {
            throw new ApiException("Movie with this title not found");
        }
        return movie.getRating();
    }

    public List<Movie> aboveRate(Integer rate) {
        List<Movie> movies = movieRepository.findMovieByRatingGreaterThan(rate);
        if (movies.isEmpty()) {
            throw new ApiException("Movie above this rate not found");
        }
        return movies;
    }

    public List<Movie> genre(String genre) {
        List<Movie> movies = movieRepository.findMovieByGenre(genre);
        if (movies.isEmpty()) {
            throw new ApiException("Movie with this genre not found");
        }
        return movies;
    }

}


