package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
}
