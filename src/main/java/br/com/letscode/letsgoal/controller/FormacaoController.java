package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.entity.Formacao;
import br.com.letscode.letsgoal.service.FormacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/formacoes")
public class FormacaoController {
    final FormacaoService formacaoService;

    @GetMapping
    public List<Formacao> findAll() {
        return formacaoService.findAll();
    }

    @PostMapping
    public Formacao saveFormacao(@RequestBody Formacao formacao) {
        // SERVIÇO - REGRA DE NEGÓCIO
        return formacaoService.saveFormacao(formacao);
    }

    @GetMapping("/{id}")
    public Formacao findById(@PathVariable Long id) {
        return formacaoService.findById(id);
    }

}
