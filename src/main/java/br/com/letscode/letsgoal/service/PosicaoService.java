package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.PosicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicaoService {

    final PosicaoRepository posicaoRepository;

    public PosicaoService(PosicaoRepository posicaoRepository) {
        this.posicaoRepository = posicaoRepository;
    }

    public Posicao saveFormacao(Posicao posicao) {
        return posicaoRepository.save(posicao);
    }

    public List<Posicao> saveFormacoes(List<Posicao> posicoes){
        return (List<Posicao>) posicaoRepository.saveAll(posicoes);
    }

    public List<Posicao> findAll() {
        return (List<Posicao>) posicaoRepository.findAll();
    }

    public Posicao findById(Long id) {
        Posicao posicao = posicaoRepository
                .findById(id)
                .orElseThrow(() -> new PatrocinadorNotFoundException());
        return posicao;
    }
}
