package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.repository.LetsClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LetsClubeService {
    final LetsClubeRepository letsClubeRepository;

    public LetsClube saveLetsClube(LetsClube letsClube) {
        return letsClubeRepository.save(letsClube);
    }
    public List<LetsClube> findAll() {
        return (List<LetsClube>) letsClubeRepository.findAll();
    }

    public LetsClube findById(Long id) {
        return letsClubeRepository
                .findById(id)
                .orElseThrow(LetsClubeNotFoundException::new);
    }
}
