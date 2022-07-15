package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.data.repository.CrudRepository;

public interface PosicaoRepository extends CrudRepository<Posicao, Long> {

}
