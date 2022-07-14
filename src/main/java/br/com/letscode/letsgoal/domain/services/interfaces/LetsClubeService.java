package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.models.LetsClube;

import java.util.List;
import java.util.Optional;

public interface LetsClubeService {

    List<LetsClube> findAll();
    Optional<LetsClube> findById(Long id);
    LetsClube save(LetsClube entity);
}
