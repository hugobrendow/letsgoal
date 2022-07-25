package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
