package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PatrocinadorDTORequest;
import br.com.letscode.letsgoal.dto.PatrocinadorDTOResponse;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public ResponseEntity<List<PatrocinadorDTOResponse>> findAll() {
        List<PatrocinadorDTOResponse> all = patrocinadorService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrocinadorDTOResponse> findById(@PathVariable Long id) {
        PatrocinadorDTOResponse byid = patrocinadorService.findByid(id);
        return ResponseEntity.ok().body(byid);
    }

    @PostMapping
    public ResponseEntity<PatrocinadorDTOResponse> save(@RequestBody @Valid PatrocinadorDTORequest patrocinadorDTORequest) {
        PatrocinadorDTOResponse save = patrocinadorService.save(patrocinadorDTORequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatrocinadorDTOResponse> updatePatrocinador(@PathVariable Long id,
                                                                      @RequestBody @Valid PatrocinadorDTORequest patrocinadorDTORequest) {
        PatrocinadorDTOResponse update = patrocinadorService.update(id, patrocinadorDTORequest);
        return ResponseEntity.ok().body(update);
    }

}
