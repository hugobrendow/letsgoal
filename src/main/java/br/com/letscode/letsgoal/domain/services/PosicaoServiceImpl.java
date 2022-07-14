package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.models.Posicao;
import br.com.letscode.letsgoal.domain.repositories.PosicaoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.PosicaoService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosicaoServiceImpl implements PosicaoService {

    private final PosicaoRepository repository;

    public PosicaoServiceImpl(PosicaoRepository repository) {
        this.repository = repository;
    }

    public List<Posicao> findAll(){
        return (List<Posicao>) repository.findAll();
    }

    public Posicao findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }
}
