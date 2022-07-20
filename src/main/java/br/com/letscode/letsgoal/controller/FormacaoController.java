package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.FormacaoDTOResponse;
import br.com.letscode.letsgoal.service.FormacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    private final FormacaoService formacaoService;

    public FormacaoController(FormacaoService formacaoService) {
        this.formacaoService = formacaoService;
    }

    @GetMapping
    public ResponseEntity<List<FormacaoDTOResponse>> findAll(){
        List<FormacaoDTOResponse> all = formacaoService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacaoDTOResponse> findById(@PathVariable Long id){
        FormacaoDTOResponse byId = formacaoService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

//    @PostMapping
//    public Formacao save(@RequestBody Formacao formacao) {
//        // SERVIÇO - REGRA DE NEGÓCIO
//        return formacao;
//    }

}
