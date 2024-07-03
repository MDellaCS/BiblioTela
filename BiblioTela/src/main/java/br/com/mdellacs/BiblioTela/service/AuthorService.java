package br.com.mdellacs.BiblioTela.service;

import br.com.mdellacs.BiblioTela.model.Author;
import br.com.mdellacs.BiblioTela.model.Book;
import br.com.mdellacs.BiblioTela.repository.AuthorRepository;
import br.com.mdellacs.BiblioTela.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author registerAuthor(String nome, List<Book> livros) {
        Author newAuthor = new Author();
        newAuthor.setNome(nome);
        newAuthor.setLivros(livros);
        for (Book book : livros) {
            book.getAutores().add(newAuthor);
            bookRepository.save(book);
        }
        return authorRepository.save(newAuthor);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
