package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @GetMapping
    public List<Clube> findAll() {
        Clube clube = new Clube();
        List<Clube> clubes = List.of(clube);
        return clubes;
    }

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube) { return clube;}

    @GetMapping("/{id}")
    public Clube findById(@PathVariable Long id) {
        Clube clube = new Clube();
        return new Clube(clube.getId(), clube.getNome(), clube.getAbreviacao(), clube.getEscudos(), clube.getNomeFantasia());
    }

    @PostMapping("/{id}")
    public Clube updateClube(@PathVariable Long id,
                             @RequestBody Clube clube) {
        return clube;
    }
}
