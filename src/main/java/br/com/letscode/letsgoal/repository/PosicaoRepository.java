package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PosicaoRepository extends JpaRepository<Posicao,Long> {
    Optional<Posicao> findByNome(String nome);
}
