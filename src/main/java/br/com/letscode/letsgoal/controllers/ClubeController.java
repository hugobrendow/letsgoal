package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.ClubeDto;
import br.com.letscode.letsgoal.domain.dto.EscudoDto;
import br.com.letscode.letsgoal.domain.models.Clube;
import br.com.letscode.letsgoal.domain.models.Escudo;
import br.com.letscode.letsgoal.domain.services.interfaces.ClubeService;
import br.com.letscode.letsgoal.domain.services.interfaces.EscudoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeService service;

    public ClubeController(ClubeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Clube>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clube> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Clube> save(@RequestBody ClubeDto request){
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clube> update(@PathVariable Long id,
                                          @RequestBody ClubeDto request){
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }
}
