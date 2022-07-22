package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.repository.LetsClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LetsClubeServiceImp implements LetsClubeService {
    private final LetsClubeRepository letsClubeRepository;

    public LetsClube saveLetsClub(LetsClube letsClube) {
        return letsClubeRepository.save(letsClube);
    }

    public List<LetsClube> findAll() {
        return  letsClubeRepository.findAll();
    }

    public LetsClube findByID(Long id) {
        return letsClubeRepository
                .findById(id)
                .orElseThrow(() -> new LetsClubeNotFoundException());
    }

    public LetsClube updateLetsClub(Long id, LetsClube letsClube) {
        letsClubeRepository
                .findById(id)
                .orElseThrow(() -> new LetsClubeNotFoundException());
        letsClube.setId(id);
        return letsClubeRepository.save(letsClube);
    }
}
