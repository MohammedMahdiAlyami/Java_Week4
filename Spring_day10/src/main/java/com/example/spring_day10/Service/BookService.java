package com.example.spring_day10.Service;

import com.example.spring_day10.ApiException.ApiException;
import com.example.spring_day10.Model.Book;
import com.example.spring_day10.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBook() {
        List<Book> Books = bookRepository.findAll();
        return Books;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book, Integer id) {
        Book oldBook = bookRepository.getById(id);
        if (oldBook == null) {

            throw new ApiException("Book not found");
        }
        oldBook.setAuthor(book.getAuthor());
        oldBook.setIsbn(book.getIsbn());
        oldBook.setCategory(book.getCategory());
        oldBook.setTitle(book.getTitle());
        oldBook.setNumberOfPages(book.getNumberOfPages());

        bookRepository.save(oldBook);

    }

    public void deleteBook(Integer id){
        Book oldBok=bookRepository.findBookById(id);
        if(oldBok==null){
            throw new ApiException("Blog not found");
        }
        bookRepository.deleteById(id);
    }

    public List<Book> findBookByCategory(String category){

        List<Book> books=  bookRepository.findBookByCategory(category);
        if (books==null){
            throw new ApiException("blog with this category not found");
        }
        return books;
    }

    public List<Book> findBookbypage(){
        List<Book> books=  bookRepository.findBookByNumberOfPagesGreaterThanEqual(300);
        if (books==null){
            throw new ApiException("blog with this category not found");
        }
        return books;
    }

    public List<Book> findBookByAuthor(String author){
        List<Book> books=  bookRepository.findBookByAuthor(author);
        if (books==null){
            throw new ApiException("blog with this Author not found");
        }
        return books;}

    public List<Book> findBookByTitle(String title){
        List<Book> books=  bookRepository.findBookByTitle(title);
        if (books==null){
            throw new ApiException("blog with this title not found");
        }
        return books;
    }


}