package com.example.project_4.Repository;

import com.example.project_4.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);

    List<Movie> findMovieByDirectorid(Integer id);
    List<Movie> findMovieByRatingGreaterThan(Integer rate);

    List<Movie> findMovieByGenre(String genre);
}
