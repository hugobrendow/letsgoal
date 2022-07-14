package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.LetsClubeDto;
import br.com.letscode.letsgoal.domain.models.LetsClube;
import br.com.letscode.letsgoal.domain.services.interfaces.LetsClubeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    private final LetsClubeService service;

    public LetsClubeController(LetsClubeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LetsClube>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetsClube> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LetsClube> saveLetsClube(@RequestBody @Valid LetsClubeDto request){
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LetsClube> update(@PathVariable Long id,
                                            @RequestBody @Valid LetsClubeDto request){
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }
}
