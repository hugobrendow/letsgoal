package br.com.letscode.letsgoal.domain.repositories;

import br.com.letscode.letsgoal.domain.models.Formacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends CrudRepository<Formacao, Long> {
}