package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.Posicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PosicaoRepository extends CrudRepository<Posicao, Long> {

    Optional<Posicao> findByAbreviacao(String abreviacao);
}
