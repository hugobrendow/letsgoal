package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.models.Patrocinador;
import br.com.letscode.letsgoal.domain.repositories.PatrocinadorRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.PatrocinadorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorServiceImpl implements PatrocinadorService {

    private final PatrocinadorRepository repository;

    public PatrocinadorServiceImpl(PatrocinadorRepository repository) {
        this.repository = repository;
    }

    public List<Patrocinador> findAll(){
        return (List<Patrocinador>) repository.findAll();
    }

    public Optional<Patrocinador> findById(Long id){
        return repository.findById(id);
    }

    public Patrocinador save(Patrocinador entity){
        return repository.save(entity);
    }
}
