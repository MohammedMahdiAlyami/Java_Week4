package com.example.project_4.Repository;

import com.example.project_4.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    Director findDirectorById(Integer id);

    Director findDirectorByName(String name);

}