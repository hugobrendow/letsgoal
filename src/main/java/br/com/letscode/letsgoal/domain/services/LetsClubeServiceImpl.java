package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.models.LetsClube;
import br.com.letscode.letsgoal.domain.repositories.LetsClubeRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.LetsClubeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetsClubeServiceImpl implements LetsClubeService {

    private final LetsClubeRepository repository;

    public LetsClubeServiceImpl(LetsClubeRepository repository) {
        this.repository = repository;
    }

    public List<LetsClube> findAll(){
        return (List<LetsClube>) repository.findAll();
    }

    public Optional<LetsClube> findById(Long id){
        return repository.findById(id);
    }

    public LetsClube save(LetsClube entity){
        return repository.save(entity);
    }
}
