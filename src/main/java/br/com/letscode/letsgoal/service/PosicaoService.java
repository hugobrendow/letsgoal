package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.PosicaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PosicaoService {
    final PosicaoRepository posicaoRepository;

    public Posicao save(Posicao posicao) {
        Optional<Posicao> optionalPosicao = posicaoRepository.findById(posicao.getId());
        optionalPosicao.ifPresent(obj -> { throw new ClienteExistenteException(); });
        return posicaoRepository.save(posicao);
    }

    public List<Posicao> findAll() {
        return posicaoRepository.findAll();
    }
    public void saveAll(List<Posicao> posicoes) {
        posicaoRepository.saveAll(posicoes);
    }

}
