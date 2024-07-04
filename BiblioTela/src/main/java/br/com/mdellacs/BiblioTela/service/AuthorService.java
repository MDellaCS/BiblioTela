package br.com.mdellacs.BiblioTela.service;

import br.com.mdellacs.BiblioTela.model.Author;
import br.com.mdellacs.BiblioTela.model.Book;
import br.com.mdellacs.BiblioTela.repository.AuthorRepository;
import br.com.mdellacs.BiblioTela.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Author registerAuthor(String nome, List<Book> livros) {
        Author newAuthor = new Author();
        newAuthor.setNome(nome);

        for (Book livro : livros) {
            livro.getAutores().add(newAuthor); // Adiciona o autor ao livro
            bookRepository.save(livro); // Salva o livro
        }

        newAuthor.setLivros(livros); // Associa os livros ao autor
        return authorRepository.save(newAuthor); // Salva o autor
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
