package com.example.project_4.Controller;

import com.example.project_4.Model.Movie;
import com.example.project_4.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getAllMovie(){
        List<Movie> movies = movieService.getAllMovie();
        return ResponseEntity.status(200).body(movies);
    }


    @PostMapping("/add")
    public ResponseEntity addMovie (@RequestBody @Valid Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
        }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @PathVariable Integer id,@Valid @RequestBody Movie movie) {
        movieService.updateMovie(id,movie);
        return ResponseEntity.status(200).body("Movie updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@Valid@PathVariable Integer id ){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }


    @GetMapping("/getbytitle/{title}")
    public ResponseEntity getMovieByTitle(@Valid @PathVariable String title){
        Movie movie=movieService.findMovieByTitle(title);
        return ResponseEntity.status(200).body(movie);
    }


    @GetMapping("/getbyduration/{title}")
    public ResponseEntity getMovieDurationByTitle(@Valid @PathVariable String title){
        Integer duration =movieService.getMovieDurationByTitle(title);
        return ResponseEntity.status(200).body(duration);
    }


    @GetMapping("/getbyrate/{title}")
    public ResponseEntity getMovieRate(@Valid @PathVariable String title){
        Integer rate =movieService.getMovieRate(title);
        return ResponseEntity.status(200).body(rate);
    }


    @GetMapping("/abovebyrate/{rate}")
    public ResponseEntity movieAboveRate(@Valid@PathVariable Integer rate){
        List<Movie> movies=movieService.aboveRate(rate);
        return ResponseEntity.status(200).body(movies);
    }


    @GetMapping("/genre/{genre}")
    public ResponseEntity genre(@Valid@PathVariable String genre){
        List<Movie> movies=movieService.genre(genre);
        return ResponseEntity.status(200).body(movies);
    }


}
