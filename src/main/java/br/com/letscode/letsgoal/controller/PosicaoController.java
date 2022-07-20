package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PosicaoDTOResponse;
import br.com.letscode.letsgoal.service.PosicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    private final PosicaoService posicaoService;

    public PosicaoController(PosicaoService posicaoService) {
        this.posicaoService = posicaoService;
    }

    @GetMapping
    public ResponseEntity<List<PosicaoDTOResponse>> findAll(){
        List<PosicaoDTOResponse> all = posicaoService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosicaoDTOResponse> findById(@PathVariable Long id){
        PosicaoDTOResponse byId = posicaoService.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}
