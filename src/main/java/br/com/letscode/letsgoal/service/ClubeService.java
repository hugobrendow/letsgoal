package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.ObjectNotFoundException;
import br.com.letscode.letsgoal.exception.ObjetoExistenteException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubeService {
    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {

        this.clubeRepository = clubeRepository;
    }

    public List<Clube> salvarClubes(List<Clube> clubes) {

        return clubeRepository.saveAll(clubes);
    }

    public Clube salvar(Clube clube) {
        Optional<Clube> optionalClube = clubeRepository.findByNomeOrAbreviacao(clube.getNome(), clube.getAbreviacao());
        optionalClube.ifPresent(obj -> {
            throw new ObjetoExistenteException();
        });

        Clube clubeSalvo = clubeRepository.save(clube);
        return clubeSalvo;
    }

    public Clube atualizar(Clube clube, Long id) {
        clubeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        clube.setId(id);
        return clubeRepository.save(clube);
    }

    public Clube buscaPorId(Long id) {
        return clubeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
    }

    public List<Clube> listar() {
        return clubeRepository.findAll();
    }
}
