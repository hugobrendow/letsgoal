package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.entity.Mercado;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @GetMapping
    public List<Mercado> viewStatus(Mercado status) {
        return (List<Mercado>) status;
    }

    @GetMapping("/{id}")
    public Mercado findById(@PathVariable Long id, @RequestBody Mercado mercado) {
        return mercado;
    }

    @PutMapping("/{id}")
    public Mercado updateMercado(@PathVariable Long id,
                                      @RequestBody Mercado mercado) {
        return mercado;
    }

}
