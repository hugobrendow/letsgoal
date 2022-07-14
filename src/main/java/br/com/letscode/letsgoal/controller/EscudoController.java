package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Escudo;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

    @RestController
    @RequestMapping("/escudos")
    public class EscudoController {
        @GetMapping
        public List<Escudo> findAll() {
            Escudo escudo = new Escudo();

            //REGRAS

            return Arrays.asList(escudo);
        }

        @GetMapping("{/id}")
        public Escudo findById(@PathVariable Long id){
            Escudo escudo = new Escudo();

            //REGRAS

            return escudo;
        }

        @PostMapping
        public Escudo saveEscudo(@RequestBody Escudo escudo){

            //REGRAS

            return escudo;
        }

        @PutMapping("{/id}")
        public Escudo updateEscudo(@PathVariable Long id, @RequestBody Escudo escudo){

            //REGRAS

            return escudo;
        }

    }

