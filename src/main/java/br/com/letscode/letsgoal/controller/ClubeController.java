package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @GetMapping
    public List<Clube> findAll(){
        return Collections.emptyList();
    }

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube){
        return clube;
    }

    @GetMapping("{/id}")
    public Clube findById(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{id}")
    public Clube updateClube(@PathVariable Long id,
                             @RequestBody Clube clube){
        return clube;
    }
}
