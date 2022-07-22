package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.DadoExistenteException;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatrocinadorServiceImp implements PatrocinadorService{

    private final PatrocinadorRepository patrocinadorRepository;

    public Patrocinador savePatrocinador(Patrocinador patrocinador) {
        Optional<Patrocinador> optionalPatrocinador = patrocinadorRepository.findByNome(patrocinador.getNome());
        optionalPatrocinador.ifPresent(obj -> {throw new DadoExistenteException();});
        return patrocinadorRepository.save(patrocinador);
    }

    public List<Patrocinador> findAll() {

        return (List<Patrocinador>) patrocinadorRepository.findAll();
    }

    public Patrocinador findById(Long id) {
        Patrocinador patrocinador = patrocinadorRepository
                .findById(id)
                .orElseThrow(() -> new PatrocinadorNotFoundException());
        return patrocinador;
    }

    public Patrocinador updatePatrocinador(Long id, Patrocinador patrocinador) {
        patrocinadorRepository.findById(id)
                .orElseThrow(() -> new PatrocinadorNotFoundException());
        patrocinador.setId(id);
        return patrocinadorRepository.save(patrocinador);
    }

}
