package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.service.ClubeService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private ClubeService clubeService;

    public ClubeController(ClubeService clubeService){
        this.clubeService = clubeService;
    }

    @GetMapping
    public List<Clube> findAll() {
        return clubeService.findAll();
    }

    @GetMapping("{/id}")
    public Clube findById(@PathVariable Long id){
        return clubeService.findById(id);
    }

    @PostMapping
    public Clube saveClube(@RequestBody Clube clube){
        return clubeService.saveClube(clube);
    }

    @PutMapping("{/id}")
    public Clube updateClube(@PathVariable Long id, @RequestBody Clube clube){
        return clube;
    }

}
