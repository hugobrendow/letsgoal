package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.EscudoDto;
import br.com.letscode.letsgoal.domain.models.Escudo;

import java.util.List;

public interface EscudoService {

    List<Escudo> findAll();
    Escudo findById(Long id);
    Escudo save(EscudoDto request);
    Escudo update(Long id, EscudoDto request);
}
