package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClubeRepository extends JpaRepository<Clube,Long> {
    Optional<Clube> findByNomeDoClubeOrAbreviacaoOrNomeFantasia(String nomeDoClube, String abreviacao, String nomeFantasia);
}
