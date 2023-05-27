package com.example.project_4.Controller;

import com.example.project_4.Model.Director;
import com.example.project_4.Model.Movie;
import com.example.project_4.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/director")
public class DirectorController {

    private final DirectorService directorService;


    @GetMapping("/get")
    public ResponseEntity getAllDirector() {
        List<Director> directors = directorService.getAllDirector();
        return ResponseEntity.status(200).body(directors);
    }


    @PostMapping("/add")
    public ResponseEntity AddDirector(@RequestBody @Valid Director director) {
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@Valid @PathVariable Integer id, @Valid @RequestBody Director director) {
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("Director updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@Valid @PathVariable Integer id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted");
    }


    @GetMapping("/directorbymovie/{Name}")
    public ResponseEntity getDirectorNameByMovieName(@Valid @PathVariable String mName){
        String directorName= directorService.getDirectorNameByMovieName(mName);
        return ResponseEntity.status(200).body(directorName);
    }


    @GetMapping("/moviebydirector/{Name}")
    public ResponseEntity getDirectorMovies(@Valid @PathVariable String dName){
        List<Movie> movies=directorService.getDirectorMovies(dName);
        return ResponseEntity.status(200).body(movies);
    }

}
