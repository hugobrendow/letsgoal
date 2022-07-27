package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.domain.models.Posicao;
import br.com.letscode.letsgoal.domain.repositories.PosicaoRepository;
import br.com.letscode.letsgoal.domain.services.interfaces.PosicaoService;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Posicao findByAbreviacao(String abreviacao) {
        return repository.findByAbreviacao(abreviacao).orElseThrow(()-> new ResourceNotFoundException(abreviacao));
    }

    public Posicao save(Posicao posicao){
        return repository.save(posicao);
    }

    public List<Posicao> saveAll(List<Posicao> posicaos){
        return (List<Posicao>) repository.saveAll(posicaos);
    }
}
