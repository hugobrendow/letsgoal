package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.dto.PatrocinadorDto;
import br.com.letscode.letsgoal.domain.models.Patrocinador;
import br.com.letscode.letsgoal.domain.repositories.PatrocinadorRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.PatrocinadorService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinadorServiceImpl implements PatrocinadorService {

    private final PatrocinadorRepository repository;

    public PatrocinadorServiceImpl(PatrocinadorRepository repository) {
        this.repository = repository;
    }

    public List<Patrocinador> findAll(){
        return (List<Patrocinador>) repository.findAll();
    }

    public Patrocinador findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Patrocinador save(PatrocinadorDto request){
        Patrocinador entity = new Patrocinador();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }

    public Patrocinador update(Long id, PatrocinadorDto request) {
        Patrocinador foundEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, foundEntity);
        return repository.save(foundEntity);
    }

    public List<Patrocinador> saveAll(List<Patrocinador> patrocinadors) {
        return (List<Patrocinador>) repository.saveAll(patrocinadors);
    }
}
