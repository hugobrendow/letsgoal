package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClienteExistenteException;
import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubeService {
    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public Clube save(Clube clube) {
        Optional<Clube> optionalClube = clubeRepository.findByNomeOrAbreviacaoOrNomeFantasia(clube.getNome(), clube.getAbreviacao(), clube.getNomeFantasia());
        optionalClube.ifPresent(obj -> { throw new ClienteExistenteException(); });
        return clubeRepository.save(clube);
    }

    public Clube update(Clube clube, Long id) {
        clubeRepository.findById(id).orElseThrow(ClubeNotFoundException::new);
        clube.setId(id);
        return clubeRepository.save(clube);
    }

    public Clube findById(Long id) {
        return clubeRepository.findById(id).orElseThrow(ClubeNotFoundException::new);
    }

    public List<Clube> findAll() {
        return clubeRepository.findAll();
    }
    public void saveAll(List<Clube> clubes) {
         clubeRepository.saveAll(clubes);
    }

}
