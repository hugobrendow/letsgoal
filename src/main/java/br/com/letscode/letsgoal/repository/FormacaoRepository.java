package br.com.letscode.letsgoal.repository;

import br.com.letscode.letsgoal.model.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Long> {
}
