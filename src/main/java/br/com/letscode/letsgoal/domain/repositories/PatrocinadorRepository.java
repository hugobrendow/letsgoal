package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.Patrocinador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends CrudRepository<Patrocinador, Long> {
}
