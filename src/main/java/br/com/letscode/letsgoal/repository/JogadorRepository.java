package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.entity.Jogador;
import org.springframework.data.repository.CrudRepository;

public interface JogadorRepository extends CrudRepository<Jogador, Long> {
}
