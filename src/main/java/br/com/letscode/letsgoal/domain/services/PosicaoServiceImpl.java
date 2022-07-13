package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.models.Posicao;
import br.com.letscode.letsgoal.domain.repositories.PosicaoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.PosicaoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PosicaoServiceImpl implements PosicaoService {

    private final PosicaoRepository repository;

    public PosicaoServiceImpl(PosicaoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Posicao> findAll(){
        return repository.findAll();
    }

    public Optional<Posicao> findById(Long id){
        return repository.findById(id);
    }

    public Posicao savePosicao(Posicao entity){
        return repository.save(entity);
    }
}
