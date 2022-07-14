package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.LetsClube;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetsClubeRepository extends CrudRepository<LetsClube, Long> {
}
