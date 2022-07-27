package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.FormacaoDto;
import br.com.letscode.letsgoal.domain.models.Formacao;
import br.com.letscode.letsgoal.domain.services.interfaces.FormacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class FormacaoController {

    private final FormacaoService service;

    public FormacaoController(FormacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Formacao>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formacao> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Formacao> save(@RequestBody @Valid FormacaoDto request){
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }
}
