package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
}
