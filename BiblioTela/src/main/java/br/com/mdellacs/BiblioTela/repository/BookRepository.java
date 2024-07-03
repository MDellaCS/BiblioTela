package br.com.mdellacs.BiblioTela.repository;

import br.com.mdellacs.BiblioTela.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
