package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatrocinadorService {
    final PatrocinadorRepository patrocinadorRepository;

    public Patrocinador savePatrocinador(Patrocinador patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    public List<Patrocinador> findAll() throws PatrocinadorNotFoundException {
        List<Patrocinador> patrocinadores =  (List<Patrocinador>) patrocinadorRepository.findAll();
        if (patrocinadores.isEmpty()) {
            throw new PatrocinadorNotFoundException();
        }
        return patrocinadores;
    }

    public Patrocinador findById(Long id) {
        return patrocinadorRepository
                .findById(id)
                .orElseThrow(PatrocinadorNotFoundException::new);
    }
}
