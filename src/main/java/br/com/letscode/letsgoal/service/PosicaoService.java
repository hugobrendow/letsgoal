package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.PosicaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PosicaoService {
    PosicaoRepository posicaoRepository;

    public List<Posicao> listar() {
        return posicaoRepository.findAll();
    }

    public List<Posicao> salvarPosicoes(List<Posicao> posicoes) {
        return posicaoRepository.saveAll(posicoes);
    }
}
