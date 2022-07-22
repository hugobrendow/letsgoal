package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    Optional<Jogador> findByIdOrNome(Long id,String nome);

}
