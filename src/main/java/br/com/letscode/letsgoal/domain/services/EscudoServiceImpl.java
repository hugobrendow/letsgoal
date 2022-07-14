package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.dto.EscudoDto;
import br.com.letscode.letsgoal.domain.dto.JogadorDto;
import br.com.letscode.letsgoal.domain.models.Escudo;
import br.com.letscode.letsgoal.domain.models.Jogador;
import br.com.letscode.letsgoal.domain.repositories.EscudoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.EscudoService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscudoServiceImpl implements EscudoService {

    private final EscudoRepository repository;

    public EscudoServiceImpl(EscudoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Escudo> findAll() {
        return (List<Escudo>) repository.findAll();
    }

    @Override
    public Escudo findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    public Escudo save(EscudoDto request) {
        Escudo entity = new Escudo();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }

    @Override
    public Escudo update(Long id, EscudoDto request) {
        Escudo foundEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, foundEntity);
        return repository.save(foundEntity);
    }
}
