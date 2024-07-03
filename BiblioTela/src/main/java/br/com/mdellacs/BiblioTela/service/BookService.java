package br.com.mdellacs.BiblioTela.service;

import br.com.mdellacs.BiblioTela.model.Book;
import br.com.mdellacs.BiblioTela.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository BookRepository;

    public BookService(BookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }

    public Book registerBook(String name, String email) {
        Book newBook = new Book();
        newBook.setName(name);
        newBook.setEmail(email);
        return BookRepository.save(newBook);
    }

    public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }
}
