package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.models.Posicao;
import br.com.letscode.letsgoal.domain.services.interfaces.PosicaoService;
import br.com.letscode.letsgoal.domain.services.PosicaoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    private final PosicaoService service;

    public PosicaoController(PosicaoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Posicao>> findAll(){
        Iterable<Posicao> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posicao> findById(@PathVariable Long id){
        Optional<Posicao> optional = service.findById(id);
        return new ResponseEntity<>(optional.orElseThrow(), HttpStatus.OK);
    }
}
