package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.models.Posicao;
import br.com.letscode.letsgoal.domain.services.interfaces.PosicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    private final PosicaoService service;

    public PosicaoController(PosicaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Posicao>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posicao> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
