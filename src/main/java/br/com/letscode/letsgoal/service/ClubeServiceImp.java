package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubeServiceImp implements ClubeService{
    private final ClubeRepository clubeRepository;

    public Clube saveClube(Clube clube) {
        return clubeRepository.save(clube);
    }

    public List<Clube> findAll() {
        return (List<Clube>) clubeRepository.findAll();
    }

    public Clube findById(Long id) {
        return clubeRepository
                .findById(id)
                .orElseThrow(() -> new ClubeNotFoundException());

    }

    public Clube updateClube(Long id, Clube clube) {
        return clubeRepository
                .findById(id)
                .map((record) ->{
                    record.setAbreviacao(clube.getAbreviacao());
                    record.setNomeDoClube(clube.getNomeDoClube());
                    record.setEscudos(clube.getEscudos());
                    record.setNomeFantasia(clube.getNomeFantasia());
                    Clube updatedClube = clubeRepository.save(record);
                    return updatedClube;
                }).orElseThrow(() -> new ClubeNotFoundException());
    }
}
