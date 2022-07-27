package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.ClubeDto;
import br.com.letscode.letsgoal.domain.models.Clube;

import java.util.List;

public interface ClubeService {

    List<Clube> findAll();
    Clube findById(Long id);
    Clube save(ClubeDto request);

    List<Clube> saveAll(List<Clube> clubs);
    Clube update(Long id, ClubeDto request);
}
