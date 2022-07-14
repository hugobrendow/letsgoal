package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.ClubeDto;
import br.com.letscode.letsgoal.domain.dto.EscudoDto;
import br.com.letscode.letsgoal.domain.models.Clube;
import br.com.letscode.letsgoal.domain.models.Escudo;

import java.util.List;

public interface ClubeService {

    List<Clube> findAll();
    Clube findById(Long id);
    Clube save(ClubeDto request);
    Clube update(Long id, ClubeDto request);
}
