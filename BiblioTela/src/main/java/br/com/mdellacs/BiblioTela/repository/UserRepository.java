package br.com.mdellacs.BiblioTela.repository;

import br.com.mdellacs.BiblioTela.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
