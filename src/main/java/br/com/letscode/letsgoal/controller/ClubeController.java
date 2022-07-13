package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.service.ClubeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubes")
@AllArgsConstructor
public class ClubeController {
    private final ClubeService clubeService;

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube){
        return clubeService.saveClube(clube);
    }
    @GetMapping
    public List<Clube> findAll(){
        return clubeService.findAll();
    }
    @GetMapping("/{id}")
    public Clube findById(@PathVariable Long id){
        return clubeService.findById(id);
    }
    @PutMapping("/{id}")
    public Clube updateClube(@PathVariable Long id, @RequestBody Clube clube){
        return clubeService.updateClube(id, clube);
    }
}
