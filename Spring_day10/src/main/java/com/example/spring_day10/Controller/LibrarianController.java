package com.example.spring_day10.Controller;

import com.example.spring_day10.Model.Librarian;
import com.example.spring_day10.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAllLibrarian() {
        List<Librarian> librarians = librarianService.getAllLibrarian();
        return ResponseEntity.status(200).body(librarians);
    }

    @PostMapping("/add")
    public ResponseEntity AddLibrarian(@RequestBody @Valid Librarian librarian) {
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@Valid @RequestBody Librarian librarian, @Valid @PathVariable Integer id) {
        librarianService.updateLibrarian(librarian, id);
        return ResponseEntity.status(200).body("Librarian updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian( @Valid@PathVariable Integer id) {
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted");
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id) {
        Librarian librarian = librarianService.getLibrarianById(id);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity checkLogin(@Valid@PathVariable String username,@Valid @PathVariable String password) {
        librarianService.checkLogin(username, password);
        return ResponseEntity.status(200).body("user login successfully");
    }

    @GetMapping("/getbyemail/{email}")
    public ResponseEntity getLibrarianById(@Valid @PathVariable String email) {
        Librarian librarian = librarianService.getLibrarianByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }

}