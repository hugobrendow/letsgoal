package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
