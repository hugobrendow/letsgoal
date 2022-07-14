package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.EscudoDto;
import br.com.letscode.letsgoal.domain.dto.JogadorDto;
import br.com.letscode.letsgoal.domain.models.Escudo;
import br.com.letscode.letsgoal.domain.models.Jogador;
import br.com.letscode.letsgoal.domain.services.interfaces.EscudoService;
import br.com.letscode.letsgoal.domain.services.interfaces.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escudos")
public class EscudoController {

    private final EscudoService service;

    public EscudoController(EscudoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Escudo>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escudo> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Escudo> save(@RequestBody EscudoDto request){
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escudo> update(@PathVariable Long id,
                                          @RequestBody EscudoDto request){
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }
}
