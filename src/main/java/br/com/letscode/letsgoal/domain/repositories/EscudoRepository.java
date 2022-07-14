package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.Escudo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscudoRepository extends CrudRepository<Escudo, Long> {
}
