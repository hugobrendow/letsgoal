package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClubeExistenteException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClubeService {
    private ClubeRepository clubeRepository;

    public Clube salvar(Clube clube) {
        // Não permitir clube duplicado
        clubeRepository.findByNomeOrAbreviacao(clube.getNome(), clube.getAbreviacao())
                .ifPresent(obj -> {
                    throw new ClubeExistenteException();
                });
        return clubeRepository.save(clube);
    }
}
