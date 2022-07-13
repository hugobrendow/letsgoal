package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Formacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends CrudRepository<Formacao, Long> {
}
