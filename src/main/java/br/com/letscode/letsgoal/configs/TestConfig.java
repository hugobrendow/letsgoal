package br.com.letscode.letsgoal.configs;

import br.com.letscode.letsgoal.model.*;
import br.com.letscode.letsgoal.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final ClubeRepository clubeRepository;
    private final EscudoRepository escudoRepository;
    private final FormacaoRepository formacaoRepository;
    private final JogadorRepository jogadorRepository;
    private final LetsClubeRepository letsClubeRepository;
    private final MercadoRepository mercadoRepository;
    private final PartidaRepository partidaRepository;
    private final PatrocinadorRepository patrocinadorRepository;
    private final PosicaoRepository posicaoRepository;

    public TestConfig(ClubeRepository clubeRepository
            , EscudoRepository escudoRepository
            , FormacaoRepository formacaoRepository
            , JogadorRepository jogadorRepository
            , LetsClubeRepository letsClubeRepository
            , MercadoRepository mercadoRepository
            , PartidaRepository partidaRepository
            , PatrocinadorRepository patrocinadorRepository
            , PosicaoRepository posicaoRepository) {
        this.clubeRepository = clubeRepository;
        this.escudoRepository = escudoRepository;
        this.formacaoRepository = formacaoRepository;
        this.jogadorRepository = jogadorRepository;
        this.letsClubeRepository = letsClubeRepository;
        this.mercadoRepository = mercadoRepository;
        this.partidaRepository = partidaRepository;
        this.patrocinadorRepository = patrocinadorRepository;
        this.posicaoRepository = posicaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // populando escudo
        Escudo escudo1 = new Escudo(null
                ,"https://www.imagensempng.com.br/wp-content/uploads/2021/01/Escudo-Corinthians-Png-1024x1024.png"
                , "https://www.imagensempng.com.br/wp-content/uploads/2021/01/Escudo-Corinthians-Png-1024x1024.png"
                , "https://www.imagensempng.com.br/wp-content/uploads/2021/01/Escudo-Corinthians-Png-1024x1024.png");
        Escudo escudo2 = new Escudo(null
                ,"https://logodetimes.com/wp-content/uploads/sao-paulo.png"
                , "https://logodetimes.com/wp-content/uploads/sao-paulo.png"
                , "https://logodetimes.com/wp-content/uploads/sao-paulo.png");
        List<Escudo> escudos = new ArrayList<>(Arrays.asList(escudo1, escudo2));
        escudoRepository.saveAll(escudos);

        // populando mercado
        Mercado mercado = new Mercado(null, "Aberto");
        mercadoRepository.save(mercado);

        // populando patrocinador
        Patrocinador patrocinador1 = new Patrocinador(null
                , "Patrocinador Master"
                ,"https://www.coca-cola.com.br"
                ,"https://pt.wikipedia.org/wiki/Coca-Cola#/media/Ficheiro:Coca-Cola_logo.svg"
                , "Coca-cola");
        Patrocinador patrocinador2 = new Patrocinador(null
                , "Patrocinador Gold"
                ,"https://www.nike.com.br"
                ,"https://www.nike.com.br/images/meta/open-graph-main-image.jpg"
                , "Nike");
        List<Patrocinador> patrocinadores = new ArrayList<>(Arrays.asList(patrocinador1, patrocinador2));
        patrocinadorRepository.saveAll(patrocinadores);

        // populando clube
        // 1° criar objetos clube e depois settar os jogadores
        Clube clube1 = new Clube(null , "Sport Club Corinthians Paulista", "Corinthians"
                , escudo1, "Corinthians ltda", null);
        Clube clube2 = new Clube(null , "São Paulo Futebol Clube", "São Paulo"
                , escudo2, "São Paulo ltda", null);

        // populando jogador
        // 1° criar objetos jogador e depois settar as posições
        Jogador jogador1 = new Jogador(null, "liberado", 1000.0, 20.0
                , 10, "keke", "Kleber", null, clube1, null);
        Jogador jogador2 = new Jogador(null, "liberado", 2000.0, 30.0
                , 20, "fifi", "Filipe", null, clube1, null);
        Jogador jogador3 = new Jogador(null, "liberado", 3000.0, 40.0
                , 30, "caca", "Cásio", null, clube2, null);
        Jogador jogador4 = new Jogador(null, "liberado", 4000.0, 50.0
                , 40, "CR7", "Christiano Ronaldo", null, clube2, null);

        // populando posição
        Posicao posicao1 = new Posicao(null, "Goleiro", jogador1);
        Posicao posicao2 = new Posicao(null, "Zagueiro", jogador2);
        Posicao posicao3 = new Posicao(null, "Centroavante", jogador3);
        Posicao posicao4 = new Posicao(null, "Atacante", jogador4);

        jogador1.setPosicao(posicao1);
        jogador2.setPosicao(posicao2);
        jogador3.setPosicao(posicao3);
        jogador4.setPosicao(posicao4);

        Set<Jogador> jogadoresClube1 = new HashSet<>(Arrays.asList(jogador1, jogador2));
        Set<Jogador> jogadoresClube2 = new HashSet<>(Arrays.asList(jogador3, jogador4));
        clube1.setJogadores(jogadoresClube1);
        clube2.setJogadores(jogadoresClube2);

        List<Clube> clubes = new ArrayList<>(Arrays.asList(clube1, clube2));
        clubeRepository.saveAll(clubes);

        List<Posicao> posicoes = new ArrayList<>(Arrays.asList(posicao1, posicao2, posicao3, posicao4));
        posicaoRepository.saveAll(posicoes);

//        List<Jogador> jogadores = new ArrayList<>(Arrays.asList(jogador1,jogador2,jogador3,jogador4));
//        jogadorRepository.saveAll(jogadores);

        // populando formação
        Formacao formacao = new Formacao(null, "4-3-3", posicoes);
        formacaoRepository.save(formacao);

        // populando partida
        Partida partida = new Partida(null, clube1, clube2, LocalDate.now(),"Itaquerão"
                , "10", 2,0);
        partidaRepository.save(partida);

        // populando letsclube
        Set<Jogador> SetJogadores = new HashSet<>(Arrays.asList(jogador1,jogador2,jogador3,jogador4));
        Set<Patrocinador> setPatrocinador = new HashSet<>(Arrays.asList(patrocinador1,patrocinador2));
        LetsClube letsClube = new LetsClube(null, "letsclube", formacao,
                setPatrocinador, SetJogadores);
        letsClubeRepository.save(letsClube);
    }
}
