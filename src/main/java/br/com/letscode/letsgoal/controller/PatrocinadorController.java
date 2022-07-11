package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    @GetMapping
    public List<Patrocinador> listar() {
        Patrocinador patrocinador = new Patrocinador();
        patrocinador.setDescricao("Let's Code");
        patrocinador.setId(1L);
        patrocinador.setImagemMarca("https://letscode.com.br/images/LetsCodePass/LetsCodePassLogo.svg");
        patrocinador.setUrlLink("https://letscode.com.br");
        return List.of(patrocinador);
    }
}
