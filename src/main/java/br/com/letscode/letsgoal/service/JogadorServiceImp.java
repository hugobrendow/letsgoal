package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.JogadorNotFoundException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.repository.JogadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JogadorServiceImp implements JogadorService{
    private final JogadorRepository jogadorRepository;

    @Override
    public Jogador saveJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @Override
    public List<Jogador> findAll() {
        return (List<Jogador>) jogadorRepository.findAll();
    }

    @Override
    public Jogador findByID(Long id) {
        return jogadorRepository
                .findById(id)
                .orElseThrow(() -> new JogadorNotFoundException());
    }

    @Override
    public Jogador updateJogador(Long id, Jogador jogador) {
        return jogadorRepository
                .findById(id)
                .map(record ->{
                    record.setApelido(jogador.getApelido());
                    record.setFoto(jogador.getFoto());
                    record.setNome(jogador.getNome());
                    record.setPreco(jogador.getPreco());
                    record.setStatus(jogador.getStatus());
                    record.setMediaDePontos(jogador.getMediaDePontos());
                    record.setTotalDeJogos(jogador.getTotalDeJogos());
                    Jogador updatedJogador = jogadorRepository.save(record);
                    return updatedJogador;
                }).orElseThrow(() ->new JogadorNotFoundException());
    }
}
