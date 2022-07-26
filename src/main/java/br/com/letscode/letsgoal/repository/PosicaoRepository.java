package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicaoRepository extends JpaRepository<Posicao, Long> {
}
