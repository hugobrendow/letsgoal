package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.models.Formacao;

import java.util.List;
import java.util.Optional;

public interface FormacaoService {

    List<Formacao> findAll();
    Optional<Formacao> findById(Long id);
    Formacao save(Formacao entity);
}
