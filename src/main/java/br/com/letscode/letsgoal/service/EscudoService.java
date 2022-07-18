package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.repository.EscudoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscudoService {
    private final EscudoRepository escudoRepository;

    public EscudoService(EscudoRepository escudoRepository) {
        this.escudoRepository = escudoRepository;
    }

    public Escudo saveEscudo(Escudo escudo) {
        return escudoRepository.save(escudo);
    }

    public List<Escudo> findAll() {
        return (List<Escudo>) escudoRepository.findAll();
    }

    public Escudo findById(Long id){
        return escudoRepository
                .findById(id)
                .orElseThrow(EscudoNotFoundException::new);
    }

    public Escudo updateEscudo(Long id, Escudo escudoAtualizado) {
        Escudo escudoAtual = escudoRepository
                .findById(id)
                .orElseThrow(EscudoNotFoundException::new);
        escudoAtualizado
                .setId(escudoAtual
                        .getId());
        return escudoRepository.save(escudoAtualizado);
    }

}
