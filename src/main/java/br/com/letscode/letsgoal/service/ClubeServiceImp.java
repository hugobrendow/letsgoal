package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ClubeNotFoundException;
import br.com.letscode.letsgoal.exception.DadoExistenteException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClubeServiceImp implements ClubeService{
    private final ClubeRepository clubeRepository;

    public Clube saveClube(Clube clube) {
        Optional<Clube> optionalClube = clubeRepository.findByNomeDoClubeOrAbreviacaoOrNomeFantasia(clube.getNomeDoClube(), clube.getAbreviacao(), clube.getNomeFantasia());
        optionalClube.ifPresent(obj -> {throw new DadoExistenteException();});

        return clubeRepository.save(clube);
    }

    public List<Clube> findAll() {
        return clubeRepository.findAll();
    }

    public Clube findById(Long id) {
        return clubeRepository
                .findById(id)
                .orElseThrow(() -> new ClubeNotFoundException());

    }

    public Clube updateClube(Long id, Clube clube) {
        clubeRepository.findById(id)
                .orElseThrow(() -> new ClubeNotFoundException());
        clube.setId(id);
        return clubeRepository.save(clube);
    }

    @Override
    public List<Clube> salvarClubes(List<Clube> clubes) {
        return clubeRepository.saveAll(clubes);
    }
}
