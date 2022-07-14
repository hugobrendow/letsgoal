package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.entity.Patrocinador;
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

    public List<Patrocinador> findAll() {
        return (List<Patrocinador>) patrocinadorRepository.findAll();
    }

    public Patrocinador findById(Long id) {
        return patrocinadorRepository
                .findById(id)
                .orElseThrow(PatrocinadorNotFoundException::new);
    }
}