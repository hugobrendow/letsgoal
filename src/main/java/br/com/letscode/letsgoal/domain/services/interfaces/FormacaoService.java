package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.FormacaoDto;
import br.com.letscode.letsgoal.domain.models.Formacao;

import java.util.List;

public interface FormacaoService {

    List<Formacao> findAll();
    Formacao findById(Long id);
    Formacao save(FormacaoDto entity);
}
