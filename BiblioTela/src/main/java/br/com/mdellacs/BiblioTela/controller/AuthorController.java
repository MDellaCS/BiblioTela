package br.com.mdellacs.BiblioTela.controller;

import br.com.mdellacs.BiblioTela.model.Author;
import br.com.mdellacs.BiblioTela.model.Book;
import br.com.mdellacs.BiblioTela.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthorController {

    private final AuthorService AuthorService;

    public AuthorController(AuthorService AuthorService) {
        this.AuthorService = AuthorService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Teste Author";
    }

    @PostMapping("/register")
    public Author registerAuthor(@RequestParam String nome, @RequestBody List<Book> livros) {
        return AuthorService.registerAuthor(nome, livros);
    }

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return AuthorService.getAllAuthors();
    }
}
