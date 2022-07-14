package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PatrocinadorRequest;
import br.com.letscode.letsgoal.dto.PatrocinadorResponse;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public ResponseEntity<List<PatrocinadorResponse>> findAll() {
        List<PatrocinadorResponse> all = patrocinadorService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrocinadorResponse> findById(@PathVariable Long id) {
        PatrocinadorResponse byid = patrocinadorService.findByid(id);
        return ResponseEntity.ok().body(byid);
    }

    @PostMapping
    public ResponseEntity<PatrocinadorResponse> save(@RequestBody @Valid PatrocinadorRequest patrocinadorRequest) {
        PatrocinadorResponse save = patrocinadorService.save(patrocinadorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatrocinadorResponse> updatePatrocinador(@PathVariable Long id,
                                                           @RequestBody @Valid PatrocinadorRequest patrocinadorRequest) {
        PatrocinadorResponse update = patrocinadorService.update(id, patrocinadorRequest);
        return ResponseEntity.ok().body(update);
    }

}
