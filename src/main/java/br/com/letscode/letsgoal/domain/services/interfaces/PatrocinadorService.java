package br.com.letscode.letsgoal.domain.services.interfaces;

import br.com.letscode.letsgoal.domain.dto.PatrocinadorDto;
import br.com.letscode.letsgoal.domain.models.Patrocinador;

import java.util.List;

public interface PatrocinadorService {

    List<Patrocinador> findAll();
    Patrocinador findById(Long id);
    Patrocinador save(PatrocinadorDto request);
    Patrocinador update(Long id, PatrocinadorDto request);
    List<Patrocinador> saveAll(List<Patrocinador> patrocinadors);
}
