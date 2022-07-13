package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.FormacaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formacoes")
@AllArgsConstructor
public class FormacaoController {
    private final FormacaoService formacaoService;

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao) {
        return formacaoService.saveFormacao(formacao);
    }
    @GetMapping
    public List<Formacao> findAll() {
        return formacaoService.findAll();
    }
    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id) {
        return formacaoService.finfById(id);
    }

}
