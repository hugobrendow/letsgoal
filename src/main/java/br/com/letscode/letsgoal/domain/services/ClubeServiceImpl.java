package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.dto.ClubeDto;
import br.com.letscode.letsgoal.domain.dto.EscudoDto;
import br.com.letscode.letsgoal.domain.models.Clube;
import br.com.letscode.letsgoal.domain.models.Escudo;
import br.com.letscode.letsgoal.domain.repositories.ClubeRepository;
import br.com.letscode.letsgoal.domain.repositories.EscudoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.ClubeService;
import br.com.letscode.letsgoal.domain.services.interfaces.EscudoService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubeServiceImpl implements ClubeService {

    private final ClubeRepository repository;

    public ClubeServiceImpl(ClubeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Clube> findAll() {
        return (List<Clube>) repository.findAll();
    }

    @Override
    public Clube findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    public Clube save(ClubeDto request) {
        Clube entity = new Clube();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }

    @Override
    public Clube update(Long id, ClubeDto request) {
        Clube foundEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, foundEntity);
        return repository.save(foundEntity);
    }
}
