package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.EscudoNotFoundException;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.repository.EscudoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EscudoService {
    final EscudoRepository escudoRepository;

    public Escudo save(Escudo escudo) {
        Optional<Escudo> optionalEscudo = escudoRepository.findById(escudo.getId());
        optionalEscudo.ifPresent(obj -> {
            throw new ClienteExistenteException();
        });
        return escudoRepository.save(escudo);
    }

    public List<Escudo> findAll() {
        return escudoRepository.findAll();
    }

    public Escudo findById(Long id) {
        return escudoRepository
                .findById(id)
                .orElseThrow(EscudoNotFoundException::new);
    }

    public Escudo update(Escudo escudo, Long id) {
        escudoRepository.findById(id).orElseThrow(EscudoNotFoundException::new);
        escudo.setId(id);
        return escudoRepository.save(escudo);
    }

}
