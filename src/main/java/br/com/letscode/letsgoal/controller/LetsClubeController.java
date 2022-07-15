package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.LetsClube;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {
    @GetMapping
    public List<LetsClube> findAll() {
        LetsClube letsclube = new LetsClube();

        //REGRAS

        return Arrays.asList(letsclube);
    }

    @GetMapping("{/id}")
    public LetsClube findById(@PathVariable Long id){
        LetsClube letsclube = new LetsClube();

        //REGRAS

        return letsclube;
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsclube){

        //REGRAS

        return letsclube;
    }

    @PutMapping("{/id}")
    public LetsClube updateLetsClube(@PathVariable Long id, @RequestBody LetsClube letsclube){

        //REGRAS

        return letsclube;
    }

}
