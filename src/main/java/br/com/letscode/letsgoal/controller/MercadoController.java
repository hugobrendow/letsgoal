package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Mercado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @GetMapping
    public List<Mercado> findAll() {
        var mercado = new Mercado();
        List<Mercado> mercados = List.of(mercado);
        return mercados;
    }

    @PostMapping
    public Mercado saveMercado(@RequestBody Mercado mercado){ return mercado;}



}
