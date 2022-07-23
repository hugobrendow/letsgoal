package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.cartola.client.ClubeCartolaClient;
import br.com.letscode.letsgoal.dto.ClubeDTO;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.service.ClubeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    private ClubeService clubeService;
    private ClubeCartolaClient clubeCartolaClient;

    public ClubeController(ClubeService clubeService, ClubeCartolaClient clubeCartolaClient) {
        this.clubeService = clubeService;
        this.clubeCartolaClient = clubeCartolaClient;
    }

    @PostMapping
    public ResponseEntity<Clube> salvar(@RequestBody @Valid ClubeDTO clubeDTO) {
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeDTO, clube);
        BeanUtils.copyProperties(clubeDTO.getEscudo(), escudo);
        clube.setEscudo(escudo);
        Clube clubeSalvo = clubeService.salvar(clube);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clube> atualizar(@PathVariable("id") Long id, @RequestBody @Valid ClubeDTO clubeDTO) {
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeDTO, clube);
        BeanUtils.copyProperties(clubeDTO.getEscudo(), escudo);
        clube.setEscudo(escudo);
        Clube clubeSalvo = clubeService.atualizar(clube, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clube> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(clubeService.buscaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Clube>> listarClubes() {
        return ResponseEntity.ok().body(clubeService.listar());
    }
}
