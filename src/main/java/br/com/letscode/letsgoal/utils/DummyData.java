package br.com.letscode.letsgoal.utils;

import br.com.letscode.letsgoal.model.*;
import br.com.letscode.letsgoal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DummyData {

    @Autowired
    JogadorRepository jogadorRepository;
    @Autowired
    EscudoRepository escudoRepository;
    @Autowired
    ClubeRepository clubeRepository;
    @Autowired
    PosicaoRepository posicaoRepository;
    @Autowired
    FormacaoRepository formacaoRepository;
    @Autowired
    LetsClubeRepository letsClubeRepository;
    @Autowired
    MercadoRepository mercadoRepository;
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    PatrocinadorRepository patrocinadorRepository;


    @PostConstruct
    public void construir() {
        Escudo escudo1 = new Escudo();
        escudo1.setTam1("Tamanho 1");

        Clube clube1 = new Clube(null, "Clube One", "CO", escudo1, "Clubinho");
        clubeRepository.save(clube1);

        Posicao posicao1 = new Posicao();
        posicao1.setId(null);
        posicao1.setNome("Atacante");

        Jogador jogador = new Jogador(null, "APTO", new BigDecimal(20000), 3l, 6, "Joaozinho", "Joao", "Foto1", clube1, posicao1);

        Formacao formacao1 = new Formacao();
        formacao1.setNome("Formacao 3-4-4");
        formacao1.setPosicoes(Arrays.asList(posicao1));

        Patrocinador patrocinador1 = new Patrocinador(null, "Esportivo", "nike.com", "nike.jpg", "Nike");

        LetsClube letsClube1 = new LetsClube(null, "Lets CLube", formacao1);

        Mercado mercado1 = new Mercado(null, "OPEN");

        Partida partida1 = new Partida(null, clube1, null, LocalDateTime.now(), "Estadio", 3, 1, 0);

        escudoRepository.save(escudo1);
        posicaoRepository.save(posicao1);
        jogadorRepository.save(jogador);

        formacaoRepository.save(formacao1);
        patrocinadorRepository.save(patrocinador1);
        letsClubeRepository.save(letsClube1);
        mercadoRepository.save(mercado1);
        partidaRepository.save(partida1);
    }
}
