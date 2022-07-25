package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.ClubeDTO;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.service.ClubeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private ClubeService clubeService;

    public ClubeController(ClubeService clubeService){
        this.clubeService = clubeService;
    }

    @GetMapping
    public ResponseEntity<List<Clube>> findAll() {
        return ResponseEntity.ok().body(clubeService.findAll());
    }

    @GetMapping("{/id}")
    public ResponseEntity<Clube> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(clubeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Clube> saveClube(@RequestBody @Valid ClubeDTO clubeDTO){
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeDTO, clubeService);//Para converter ClubeDTO em Clube
        BeanUtils.copyProperties(clubeDTO.getEscudo(), escudo);//Para converter EscudoDTO em Escudo
        clube.setEscudo(escudo);
        Clube clubeSalvo = clubeService.saveClube(clube);
        return
        ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }

    @PutMapping("{/id}")
    public ResponseEntity<Clube> updateClube(@PathVariable Long id, @RequestBody @Valid ClubeDTO clubeDTO){
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeDTO, clube);//Para converter ClubeDTO em Clube
        BeanUtils.copyProperties(clubeDTO.getEscudo(), escudo);//Para converter EscudoDTO em Escudo
        clube.setEscudo(escudo);
        Clube clubeSalvo = clubeService.saveClube(clube);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }

}
