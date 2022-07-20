package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PartidaDTOResponse;
import br.com.letscode.letsgoal.service.PartidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public ResponseEntity<List<PartidaDTOResponse>> findAll(){
        List<PartidaDTOResponse> all = partidaService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaDTOResponse> findById(@PathVariable Long id){
        PartidaDTOResponse byId = partidaService.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}
