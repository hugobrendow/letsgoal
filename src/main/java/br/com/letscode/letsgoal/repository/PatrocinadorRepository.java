package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {

    Optional<Patrocinador> findByNome(String nome);
}
