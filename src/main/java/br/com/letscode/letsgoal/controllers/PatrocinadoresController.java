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

    public PatrocinadoresController(PatrocinadorServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Patrocinador>> findAll(){
        List<Patrocinador> patrocinadors = service.findAll();
        return new ResponseEntity<>(patrocinadors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrocinador> findById(@PathVariable Long id){
        Optional<Patrocinador> optional = service.findById(id);
        return new ResponseEntity<>(optional.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patrocinador> save(@RequestBody PatrocinadorDto request){
        Patrocinador model = new Patrocinador();
        BeanUtils.copyProperties(request, model);
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrocinador> update(@PathVariable Long id,
                                               @RequestBody PatrocinadorDto request){
        Patrocinador newModel = new Patrocinador();
        BeanUtils.copyProperties(request, newModel);
        Optional<Patrocinador> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(newModel, optional.get());
        service.save(optional.get());
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }
}
