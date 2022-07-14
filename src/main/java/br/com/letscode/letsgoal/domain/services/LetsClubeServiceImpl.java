package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.dto.LetsClubeDto;
import br.com.letscode.letsgoal.domain.models.LetsClube;
import br.com.letscode.letsgoal.domain.repositories.LetsClubeRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.LetsClubeService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetsClubeServiceImpl implements LetsClubeService {

    private final LetsClubeRepository repository;

    public LetsClubeServiceImpl(LetsClubeRepository repository) {
        this.repository = repository;
    }

    public List<LetsClube> findAll(){
        return (List<LetsClube>) repository.findAll();
    }

    public LetsClube findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public LetsClube save(LetsClubeDto request){
        LetsClube entity = new LetsClube();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }

    public LetsClube update(Long id, LetsClubeDto request){
        LetsClube foundEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, foundEntity);
        return repository.save(foundEntity);
    }
}
