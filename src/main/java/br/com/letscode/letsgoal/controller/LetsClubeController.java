package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    @GetMapping
    public List<LetsClube> findAll() {
        return Collections.emptyList();
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {
        return letsClube;
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                     @RequestBody LetsClube letsClube) {
        return letsClube;
    }

}
