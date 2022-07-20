package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    Logger logger = LoggerFactory.getLogger(PatrocinadorController.class);
    @GetMapping
    public List<Patrocinador> findAll() {
        logger.info("Acessando recurso do patrocinador");
        Patrocinador patrocinador = new Patrocinador(1L, "Let's Code", "https://letscode.com.br",
                                         "https://letscode.com.br", "Let's Code");
        List<Patrocinador> patrocinadores = List.of(patrocinador);
        return patrocinadores;
    }

    @PostMapping
    public Patrocinador savePatrocinador(@RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

    @GetMapping("/{id}")
    public Patrocinador findById(@PathVariable Long id) {
        Patrocinador patrocinador = new Patrocinador(id, "Let's Code", "https://letscode.com.br",
                                                     "https://letscode.com.br", "Let's Code");
        return patrocinador;
    }

    @PutMapping("/{id}")
    public Patrocinador updatePatrocinador(@PathVariable Long id, @RequestBody Patrocinador patrocinador) {
        return patrocinador;
    }

//    aula02.md
//    @GetMapping
//    public List<Patrocinador> listar() {
//        Patrocinador patrocinador = new Patrocinador();
//        patrocinador.setDescricao("Let's Code");
//        patrocinador.setId(1L);
//        patrocinador.setImagemMarca("https://letscode.com.br/images/LetsCodePass/LetsCodePassLogo.svg");
//        patrocinador.setUrlLink("https://letscode.com.br");
//        return List.of(patrocinador);
//    }
}
