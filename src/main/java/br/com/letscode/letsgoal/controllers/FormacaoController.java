package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.models.Formacao;
import br.com.letscode.letsgoal.domain.services.FormacaoServiceImpl;
import br.com.letscode.letsgoal.domain.services.interfaces.FormacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class FormacaoController {

    private final FormacaoService service;

    public FormacaoController(FormacaoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Formacao>> findAll(){
        List<Formacao> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formacao> findById(@PathVariable Long id){
        Optional<Formacao> optional = service.findById(id);
        return new ResponseEntity<>(optional.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Formacao> save(@RequestBody Formacao formacao){
        service.save(formacao);
        return new ResponseEntity<>(formacao, HttpStatus.CREATED);
    }
}
