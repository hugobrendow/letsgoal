package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Mercado;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {
    @GetMapping
    public List<Mercado> findAll() {
        Mercado mercado = new Mercado();

        //REGRAS

        return Arrays.asList(mercado);
    }

    @GetMapping("{/id}")
    public Mercado findById(@PathVariable Long id){
        Mercado mercado = new Mercado();

        //REGRAS

        return mercado;
    }

    @PostMapping
    public Mercado saveMercado(@RequestBody Mercado mercado){

        //REGRAS

        return mercado;
    }

    @PutMapping("{/id}")
    public Mercado updateMercado(@PathVariable Long id, @RequestBody Mercado mercado){

        //REGRAS

        return mercado;
    }

}

