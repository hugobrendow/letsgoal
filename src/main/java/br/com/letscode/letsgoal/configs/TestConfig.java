package br.com.letscode.letsgoal.configs;

import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repositories.PatrocinadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final PatrocinadorRepository patrocinadorRepository;

    public TestConfig(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Patrocinador patrocinador1 = new Patrocinador(null,
                "Patrocinador Master","https://www.coca-cola.com.br"
                ,"https://pt.wikipedia.org/wiki/Coca-Cola#/media/Ficheiro:Coca-Cola_logo.svg",
                "Coca-cola");
        Patrocinador patrocinador2 = new Patrocinador(null,
                "Patrocinador Gold","https://www.nike.com.br"
                ,"https://www.nike.com.br/images/meta/open-graph-main-image.jpg",
                "Nike");
        List<Patrocinador> patrocinadores = new ArrayList<>(Arrays.asList(patrocinador1, patrocinador2));
        patrocinadorRepository.saveAll(patrocinadores);
    }
}
