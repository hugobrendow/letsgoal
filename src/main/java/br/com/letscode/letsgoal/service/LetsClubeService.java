package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.LetsClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetsClubeService {

    final LetsClubeRepository letsClubeRepository;

    public LetsClubeService(LetsClubeRepository letsClubeRepository) {
        this.letsClubeRepository = letsClubeRepository;
    }

    public LetsClube saveLetsClube(LetsClube letsClube) {
        return letsClubeRepository.save(letsClube);
    }

    public List<LetsClube> findAll() {
        return (List<LetsClube>) letsClubeRepository.findAll();
    }

    public LetsClube findById(Long id) {
        LetsClube letsClube = letsClubeRepository
                .findById(id)
                .orElseThrow(() -> new LetsClubeNotFoundException());
        return letsClube;
    }

}
