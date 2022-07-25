package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatrocinadorService {
    final PatrocinadorRepository patrocinadorRepository;

    public Patrocinador save(Patrocinador patrocinador) {
        Optional<Patrocinador> optionalPatrocinador = patrocinadorRepository.findByNome(patrocinador.getNome());
        optionalPatrocinador.ifPresent(obj -> { throw new ClienteExistenteException(); });
        return patrocinadorRepository.save(patrocinador);
    }
    public Patrocinador update(Patrocinador patrocinador, Long id) {
       patrocinadorRepository.findById(id).orElseThrow(ClubeNotFoundException::new);
        patrocinador.setId(id);
        return patrocinadorRepository.save(patrocinador);
    }

    public List<Patrocinador> findAll() throws PatrocinadorNotFoundException {
        List<Patrocinador> patrocinadores =  patrocinadorRepository.findAll();
        if (patrocinadores.isEmpty()) {
            throw new PatrocinadorNotFoundException();
        }
        return patrocinadores;
    }

    public Patrocinador findById(Long id) {
        return patrocinadorRepository
                .findById(id)
                .orElseThrow(PatrocinadorNotFoundException::new);
    }
}
