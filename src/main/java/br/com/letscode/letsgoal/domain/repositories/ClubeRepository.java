package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.Clube;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubeRepository extends CrudRepository<Clube, Long> {
}
