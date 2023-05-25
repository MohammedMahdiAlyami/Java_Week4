package com.example.spring_day10.Repository;

import com.example.spring_day10.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByUsernameAndPassword(String username,String password);

    Librarian findLibrarianByEmail(String email);

}