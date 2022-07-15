package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    @GetMapping
    public List<Clube> findAll() {
        Clube clube = new Clube();

        //REGRAS

        return Arrays.asList(clube);
    }

    @GetMapping("{/id}")
    public Clube findById(@PathVariable Long id){
        Clube clube = new Clube();

        //REGRAS

        return clube;
    }

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube){

        //REGRAS

        return clube;
    }

    @PutMapping("{/id}")
    public Clube updateClube(@PathVariable Long id, @RequestBody Clube clube){

        //REGRAS

        return clube;
    }

}
