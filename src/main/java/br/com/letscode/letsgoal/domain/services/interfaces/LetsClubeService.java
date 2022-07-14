package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.LetsClubeDto;
import br.com.letscode.letsgoal.domain.models.LetsClube;

import java.util.List;

public interface LetsClubeService {

    List<LetsClube> findAll();
    LetsClube findById(Long id);
    LetsClube save(LetsClubeDto entity);
    LetsClube update(Long id, LetsClubeDto request);
}
