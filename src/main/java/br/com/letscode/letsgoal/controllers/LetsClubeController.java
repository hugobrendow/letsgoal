package br.com.letscode.letsgoal.controllers;

import br.com.letscode.letsgoal.domain.dto.LetsClubeDto;
import br.com.letscode.letsgoal.domain.models.LetsClube;
import br.com.letscode.letsgoal.domain.services.interfaces.LetsClubeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<LetsClube> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetsClube> findById(@PathVariable Long id){
        Optional<LetsClube> optional = service.findById(id);
        if (optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LetsClube> saveLetsClube(@RequestBody LetsClubeDto request){
        LetsClube model = new LetsClube();
        BeanUtils.copyProperties(request, model);
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    public ResponseEntity<LetsClube> update(@PathVariable Long id,
                                            @RequestBody LetsClubeDto request){

        LetsClube newModel = new LetsClube();
        BeanUtils.copyProperties(request, newModel);
        Optional<LetsClube> byId = service.findById(id);
        if (byId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(newModel, byId.get());
        service.save(byId.get());
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }
}
