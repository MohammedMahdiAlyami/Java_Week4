package com.example.spring_day10.Repository;

import com.example.spring_day10.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookById(Integer id);

    List<Book> findBookByCategory(String category);

    List<Book> findBookByNumberOfPagesGreaterThanEqual(Integer pages);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByTitle(String title);



}
