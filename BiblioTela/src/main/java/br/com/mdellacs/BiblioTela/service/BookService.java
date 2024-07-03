package br.com.mdellacs.BiblioTela.service;

import br.com.mdellacs.BiblioTela.model.Author;
import br.com.mdellacs.BiblioTela.model.Book;
import br.com.mdellacs.BiblioTela.repository.AuthorRepository;
import br.com.mdellacs.BiblioTela.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Book registerBook(String titulo, List<Author> autores, String isbn, String editora, String anoPublicacao,
            String genero, String sinopse) {
        Book newBook = new Book();
        newBook.setTitulo(titulo);
        newBook.setAutores(autores);
        for (Author author : autores) {
            author.getLivros().add(newBook);
            authorRepository.save(author);
        }
        newBook.setIsbn(isbn);
        newBook.setEditora(editora);
        newBook.setAnoPublicacao(anoPublicacao);
        newBook.setGenero(genero);
        newBook.setSinopse(sinopse);
        return bookRepository.save(newBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
