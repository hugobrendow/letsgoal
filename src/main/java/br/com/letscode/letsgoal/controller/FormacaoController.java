package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {


    private FormacaoService formacaoService;

    public FormacaoController(FormacaoService formacaoService) {
        this.formacaoService = formacaoService;
    }

    @GetMapping
    public List<Formacao> findAll() {
        return formacaoService.findAll();
    }

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao) {
        return formacaoService.saveFormacao(formacao);
    }

    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id) {
        return formacaoService.findById(id);
    }

}
