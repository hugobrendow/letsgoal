package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatrocinadorRepository extends CrudRepository<Patrocinador, Long> {
    Optional<Patrocinador> findByNome (String nome);

}
