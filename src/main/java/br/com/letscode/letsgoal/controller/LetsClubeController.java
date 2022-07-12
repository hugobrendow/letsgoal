package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/letsclube")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll(){
        var letsClube = new LetsClube(1L, "Curintia", new Formacao());
        List<LetsClube> list = new ArrayList<>(Arrays.asList(letsClube));
        return list;
    }

    @PostMapping
    public LetsClube saveLetsCLube(@RequestBody LetsClube letsclube) {
        return letsclube;
    }

    @GetMapping("/{id}")
    public LetsClube findById (@PathVariable Long id){
        var letsclube = new LetsClube(id, "Olimpig do Marcelo", new Formacao());
        return letsclube;
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                           @RequestBody LetsClube letsClube) {
        return letsClube;
    }
}
