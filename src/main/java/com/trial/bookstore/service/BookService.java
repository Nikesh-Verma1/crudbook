package com.trial.bookstore.service;

import com.trial.bookstore.model.Book;
import com.trial.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired

    private BookRepository bookRepository;

    public List<Book> getllBooks(){

        return  bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){

        return bookRepository.findById(id);
    }

    public  Book saveBook(Book book){

        return bookRepository.save(book);
    }

    public  Book updateBook(Long id, Book bookDetails){
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setStock(bookDetails.getStock());
            return  bookRepository.save(book);
        }).orElseThrow(()-> new RuntimeException("Book Not Found with Id" +id));
    }

    public  void  deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
