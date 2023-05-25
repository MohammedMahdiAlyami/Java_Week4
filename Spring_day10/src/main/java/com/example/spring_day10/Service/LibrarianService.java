package com.example.spring_day10.Service;

import com.example.spring_day10.ApiException.ApiException;
import com.example.spring_day10.Model.Librarian;
import com.example.spring_day10.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarian() {
        List<Librarian> librarians = librarianRepository.findAll();
        return librarians;
    }

    public void addLibrarian(Librarian librarian) {
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Librarian librarian, Integer id) {
        Librarian oldLibrarian = librarianRepository.getById(id);
        if (oldLibrarian == null) {
            throw new ApiException("Librarian not found");
        }
        oldLibrarian.setEmail(librarian.getEmail());
        oldLibrarian.setName(librarian.getName());
        oldLibrarian.setPassword(librarian.getPassword());
        oldLibrarian.setUsername(librarian.getUsername());

        librarianRepository.save(oldLibrarian);
    }

    public void deleteLibrarian(Integer id){
        Librarian oldLibrarian=librarianRepository.findLibrarianById(id);
        if(oldLibrarian==null){
            throw new ApiException("Librarian not found");
        }
        librarianRepository.deleteById(id);
    }

    public Librarian getLibrarianById(Integer id){
        Librarian librarian=librarianRepository.findLibrarianById(id);
        if(librarian==null){
            throw new ApiException("Librarian not found");
        }
        return librarian;
    }

    public void checkLogin(String username ,String password){
        Librarian librarian=librarianRepository.findLibrarianByUsernameAndPassword(username,password);
        if (librarian==null){
            throw new ApiException("Librarian not found");
        }
    }

    public Librarian getLibrarianByEmail(String email){
        Librarian librarian=librarianRepository.findLibrarianByEmail(email);
        if(librarian==null){
            throw new ApiException("Librarian not found");
        }
        return librarian;
    }


}
