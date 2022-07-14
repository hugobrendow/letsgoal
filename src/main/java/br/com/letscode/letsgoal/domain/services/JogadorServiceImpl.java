package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.dto.JogadorDto;
import br.com.letscode.letsgoal.domain.models.Jogador;
import br.com.letscode.letsgoal.domain.repositories.JogadorRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.JogadorService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository repository;

    public JogadorServiceImpl(JogadorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Jogador> findAll() {
        return (List<Jogador>) repository.findAll();
    }

    @Override
    public Jogador findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    public Jogador save(JogadorDto request) {
        Jogador entity = new Jogador();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }

    @Override
    public Jogador update(Long id, JogadorDto request) {
        Jogador foundEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, foundEntity);
        return repository.save(foundEntity);
    }
}
