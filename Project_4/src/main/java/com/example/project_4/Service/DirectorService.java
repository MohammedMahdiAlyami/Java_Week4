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
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    public List<Director> getAllDirector(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public void updateDirector(Integer id,Director director){
        Director oldDirector =directorRepository.findDirectorById(id);
        if(oldDirector==null){
            throw new ApiException("Director not found");
        }
        oldDirector.setName(director.getName());
        directorRepository.save(oldDirector);
    }


    public void deleteDirector(Integer id){
        Director oldDirector=directorRepository.findDirectorById(id);
        if(oldDirector==null){
            throw new ApiException("Director not found");
        }
        directorRepository.deleteById(id);
    }

    public String getDirectorNameByMovieName(String mName){
        Movie movie = movieRepository.findMovieByName(mName);
        if (movie == null) {
            throw new ApiException("Movie not found");
        }
        Director director=directorRepository.findDirectorById(movie.getDirectorid());
        return director.getName();
    }


    public List<Movie> getDirectorMovies(String name) {
        Director director = directorRepository.findDirectorByName(name);
        if (director == null) {
            throw new ApiException("Director not found");
        }
        List<Movie> movies = movieRepository.findMovieByDirectorid(director.getId());
        return movies;
    }


}
