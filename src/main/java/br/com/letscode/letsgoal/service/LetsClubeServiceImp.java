package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.LetsClubeNotFoundException;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Patrocinador;
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
        return (List<LetsClube>) letsClubeRepository.findAll();
    }

    public LetsClube findByID(Long id) {
        LetsClube letsClube = letsClubeRepository
                .findById(id)
                .orElseThrow(() -> new LetsClubeNotFoundException());
        return letsClube;
    }

    public LetsClube updateLetsClub(Long id, LetsClube letsClube) {
        return letsClubeRepository
                .findById(id)
                .map(record ->{
                    record.setNomeDoClub(letsClube.getNomeDoClub());
                    record.setFormacao(letsClube.getFormacao());
                    LetsClube updatedLetsClube = letsClubeRepository.save(record);
                    return updatedLetsClube;
                }).orElseThrow(() ->new LetsClubeNotFoundException());
    }
}
