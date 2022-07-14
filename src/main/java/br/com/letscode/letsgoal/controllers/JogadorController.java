package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.JogadorDto;
import br.com.letscode.letsgoal.domain.models.Jogador;
import br.com.letscode.letsgoal.domain.services.interfaces.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService service;

    public JogadorController(JogadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Jogador> save(@RequestBody @Valid JogadorDto request){
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Long id,
                                          @RequestBody @Valid JogadorDto request){
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }
}
