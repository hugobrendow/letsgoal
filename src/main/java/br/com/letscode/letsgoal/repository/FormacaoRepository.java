package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import org.springframework.data.repository.CrudRepository;

public interface FormacaoRepository extends CrudRepository<Formacao, Long> {

}