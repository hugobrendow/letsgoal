package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.cartola.dto.PatrocinadorDTORequest;
import br.com.letscode.letsgoal.cartola.dto.PatrocinadorDTOResponse;
import br.com.letscode.letsgoal.exception.PatrocinadorNotFoundException;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    private PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public ResponseEntity<List<PatrocinadorDTOResponse>> findAll() {
        List<PatrocinadorDTOResponse> patrocinadores = patrocinadorService.findAll();
        return ResponseEntity.ok().body(patrocinadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrocinadorDTOResponse> findById(@PathVariable Long id) {
        PatrocinadorDTOResponse patrocinador = patrocinadorService.findByid(id);
        return ResponseEntity.ok().body(patrocinador);
    }

    @PostMapping
    public ResponseEntity<PatrocinadorDTOResponse> savePatrocinador(@RequestBody @Valid PatrocinadorDTORequest patrocinadorDTORequest) {
        PatrocinadorDTOResponse save = patrocinadorService.savePatrocinador(patrocinadorDTORequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatrocinadorDTOResponse> updatePatrocinador(@PathVariable Long id,
                                                                      @RequestBody @Valid PatrocinadorDTORequest patrocinadorDTORequest) {
        PatrocinadorDTOResponse patrocinador = patrocinadorService.updatePatrocinador(id, patrocinadorDTORequest);
        return ResponseEntity.ok().body(patrocinador);
    }

}
