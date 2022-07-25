package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.InvalidFormacaoException;
import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.LetsClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LetsClubeService {
    final LetsClubeRepository letsClubeRepository;
    final ScheduleService scheduleService;

    public LetsClube save(LetsClube letsClube) {
        Optional<LetsClube> optionalLestClube = letsClubeRepository.findById(letsClube.getId());
        optionalLestClube.ifPresent(obj -> {
            throw new ClienteExistenteException();
        });
        return letsClubeRepository.save(letsClube);
    }

    public LetsClube update(LetsClube letsClube, Long id) {
        letsClubeRepository.findById(id).orElseThrow(LetsClubeNotFoundException::new);
        letsClube.setId(id);
        return letsClubeRepository.save(letsClube);
    }

    public List<LetsClube> findAll() {
        return letsClubeRepository.findAll();
    }

    public LetsClube findById(Long id) {
        return letsClubeRepository
                .findById(id)
                .orElseThrow(LetsClubeNotFoundException::new);
    }

    public LetsClube schedule(LetsClube letsClube) {
        if (!scheduleService.isScheduleValid(letsClube)) {
            throw new InvalidFormacaoException();
        }
        return letsClubeRepository.save(letsClube);
    }


}
