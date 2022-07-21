package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClubeRepository extends CrudRepository<Clube, Long> {

    Optional<Clube> findByNomeDoClubeOrAbreviacao(String nome, String abreviacao);
}
