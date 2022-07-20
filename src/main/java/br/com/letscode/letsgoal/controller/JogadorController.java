package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.JogadorDTOResponse;
import br.com.letscode.letsgoal.service.JogadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public ResponseEntity<List<JogadorDTOResponse>> findAll(){
        List<JogadorDTOResponse> all = jogadorService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorDTOResponse> findById(@PathVariable Long id){
        JogadorDTOResponse byId = jogadorService.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}
