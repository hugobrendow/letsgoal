package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {
    Optional<Clube> findByNomeOrAbreviacao(String nome, String abreviacao);
}
