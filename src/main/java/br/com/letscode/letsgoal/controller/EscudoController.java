package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.EscudoDTOResponse;
import br.com.letscode.letsgoal.service.EscudoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escudos")
public class EscudoController {

    private final EscudoService escudoService;

    public EscudoController(EscudoService escudoService) {
        this.escudoService = escudoService;
    }

    @GetMapping
    public ResponseEntity<List<EscudoDTOResponse>> findAll(){
        List<EscudoDTOResponse> all = escudoService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscudoDTOResponse> findById(@PathVariable Long id){
        EscudoDTOResponse byId = escudoService.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}
