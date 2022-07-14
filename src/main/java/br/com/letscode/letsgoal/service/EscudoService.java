package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.entity.Escudo;
import br.com.letscode.letsgoal.repository.EscudoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EscudoService {
    final EscudoRepository escudoRepository;

    public Escudo saveEscudo(Escudo escudo) {
        return escudoRepository.save(escudo);
    }

    public List<Escudo> findAll() {
        return (List<Escudo>) escudoRepository.findAll();
    }

    public Escudo findById(Long id) {
        return escudoRepository
                .findById(id)
                .orElseThrow(EscudoNotFoundException::new);
    }
}
