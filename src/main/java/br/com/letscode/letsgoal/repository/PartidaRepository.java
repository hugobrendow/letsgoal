package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
