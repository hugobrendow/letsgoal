package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Partida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
}
