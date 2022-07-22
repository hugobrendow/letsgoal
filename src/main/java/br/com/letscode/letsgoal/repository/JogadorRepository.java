package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador,Long> {
    Optional<Jogador> findByNomeOrApelido(String nome, String apelido);
}
