package br.com.mdellacs.BiblioTela.controller;

import br.com.mdellacs.BiblioTela.model.Book;
import br.com.mdellacs.BiblioTela.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BookController {

    private final BookService BookService;

    public BookController(BookService BookService) {
        this.BookService = BookService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Teste Book";
    }

    @PostMapping("/register")
    public String registerBook(@RequestBody Book Book) {
        Book newBook = BookService.registerBook(Book.getName(), Book.getEmail());
        return "Book registered successfully: " + newBook.getName() + ", " + newBook.getEmail();
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }
}
