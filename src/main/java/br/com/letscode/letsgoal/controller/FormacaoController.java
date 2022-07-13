package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    @Autowired
    private FormacaoService service;

    @GetMapping
    public List<Formacao> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao){
        return service.save(formacao);
    }

    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id){
        Optional<Formacao> formacao = service.findById(id);
        if (formacao.isEmpty()){
            throw new RuntimeException();
        }
        return formacao.get();
    }
}
