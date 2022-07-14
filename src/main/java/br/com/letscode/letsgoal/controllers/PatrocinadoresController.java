package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.PatrocinadorDto;
import br.com.letscode.letsgoal.domain.models.Patrocinador;
import br.com.letscode.letsgoal.domain.services.interfaces.PatrocinadorService;
import br.com.letscode.letsgoal.domain.services.PatrocinadorServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadoresController {

    private final PatrocinadorService service;

    public PatrocinadoresController(PatrocinadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Patrocinador>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrocinador> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patrocinador> save(@RequestBody PatrocinadorDto request){
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrocinador> update(@PathVariable Long id,
                                               @RequestBody PatrocinadorDto request){
        return new ResponseEntity<>(service.update(id,request), HttpStatus.OK);
    }
}
