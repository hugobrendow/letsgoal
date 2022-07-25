package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicaoRepository extends JpaRepository<Posicao, Long> {
}
