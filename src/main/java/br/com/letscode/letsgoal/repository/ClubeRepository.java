package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Clube;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubeRepository extends CrudRepository<Clube, Long> {
}
