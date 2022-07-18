package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinadorService {
    final PatrocinadorRepository patrocinadorRepository;

    public PatrocinadorService(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }

    public Patrocinador savePatrocinador(Patrocinador patrocinador){
       return patrocinadorRepository.save(patrocinador);
    }

    public List<Patrocinador> findAll(){
        return (List<Patrocinador>) patrocinadorRepository.findAll();
    }

    public Patrocinador findByid(Long id){
        return patrocinadorRepository
                .findById(id)
                .orElseThrow(PatrocinadorNotFoundException::new);
    }
}
