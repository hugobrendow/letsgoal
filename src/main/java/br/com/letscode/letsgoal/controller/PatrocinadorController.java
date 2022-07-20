package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.cartola.client.CartolaClient;
import br.com.letscode.letsgoal.cartola.client.JogadorCartolaClient;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    private PatrocinadorService patrocinadorService;
    private CartolaClient cartolaClient;
    private JogadorCartolaClient jogadoresCartolaClient;

    public PatrocinadorController(PatrocinadorService patrocinadorService, CartolaClient cartolaClient, JogadorCartolaClient jogadoresCartolaClient) {
        this.patrocinadorService = patrocinadorService;
        this.cartolaClient = cartolaClient;
        this.jogadoresCartolaClient = jogadoresCartolaClient;
    }

    @GetMapping
    public List<Patrocinador> findAll() throws IOException, InterruptedException {
        cartolaClient.listarClubes();
        jogadoresCartolaClient.listarJogadores();
        return patrocinadorService.findAll();
    }

    @PostMapping
    public Patrocinador savePatrocinador(@RequestBody Patrocinador patrocinador) {
        return patrocinadorService.savePatrocinador(patrocinador);
    }

    @GetMapping("/{id}")
    public Patrocinador findById(@PathVariable Long id) {
        return patrocinadorService.findById(id);
    }

    @PutMapping("/{id}")
    public Patrocinador updatePatrocinador(@PathVariable Long id,
                                           @RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

}
