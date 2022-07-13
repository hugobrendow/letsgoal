package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.service.LetsClubeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letsClubes")
@AllArgsConstructor
public class LetsClubeController {
    final LetsClubeService letsClubeService;
    @GetMapping
    public List<LetsClube> findAll() {
        return letsClubeService.findAll();
    }

    @PostMapping
    public LetsClube saveLetsClube(@RequestBody LetsClube letsClube) {
        return letsClubeService.saveLetsClub(letsClube) ;
    }

    @GetMapping("/{id}")
    public LetsClube findById(@PathVariable Long id) {
        return letsClubeService.findByID(id);
    }
    @PutMapping("/{id}")
    public LetsClube updateLetsClube(@PathVariable Long id,
                                           @RequestBody LetsClube letsClube) {
        return letsClubeService.updateLetsClub(id,letsClube);
    }

}
