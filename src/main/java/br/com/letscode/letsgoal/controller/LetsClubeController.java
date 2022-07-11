package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll() {
        LetsClube letsClube = new LetsClube(2L, "Let's Clube", new Formacao());
        List<LetsClube> letsClubes = List.of(letsClube);
        return letsClubes;
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) { return letsClube;}

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id) {
        return new LetsClube(id, "Let's Clube", new Formacao());
    }

    @PostMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                     @RequestBody LetsClube letsClube) {
        return letsClube;
    }
}
