package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.service.JogadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {


    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService){
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> findAll(){
        return jogadorService.listar();
    }

    @GetMapping("/{id}")
    public Jogador findById(@PathVariable Long id){
        return jogadorService.findById(id);
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        return jogadorService.salvarJogador(jogador);
    }

    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id,
                                 @RequestBody Jogador jogador) {
        //Atualiza jogador no banco de dados
        return jogador;
    }

    @DeleteMapping("/{id}")
    public Jogador deleteJogador(@PathVariable Long id,
                                 @RequestBody Jogador jogador) {
        //Deleta jogador do banco de dados
        return jogador;
    }

}
