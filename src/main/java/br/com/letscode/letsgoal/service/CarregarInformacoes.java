package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.cartola.client.ClubeCartolaClient;
import br.com.letscode.letsgoal.cartola.client.JogadorCartolaClient;
import br.com.letscode.letsgoal.cartola.dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.EscudoCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.JogadorCartolaDTO;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CarregarInformacoes implements ApplicationRunner {
    ClubeCartolaClient clubeCartolaClient;
    ClubeService clubeService;
    JogadorCartolaClient jogadorCartolaClient;
    JogadorService jogadorService;
    PosicaoService posicaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<ClubeCartolaDTO> clubeCartolaDTOS = clubeCartolaClient.listarClubes();
        List<Clube> clubes = new ArrayList<>();
        // TODO Comparar informações e atualizar
        if (clubeService.findAll().isEmpty()) {
            clubes = clubeCartolaDTOS
                    .stream()
                    .map(objeto -> {
                        EscudoCartolaDTO escudoDTO = objeto.getEscudoCartolaDTO();
                        Escudo escudo = new Escudo();
                        BeanUtils.copyProperties(escudoDTO, escudo);

                        return new Clube(
                                objeto.getId(),
                                objeto.getNome(),
                                objeto.getAbreviacao(),
                                objeto.getNomeFantasia(),
                                escudo
                        );
                    }).collect(Collectors.toList());

            clubeService.saveAll(clubes);
        }

        // TODO Comparar informações e atualizar
        if (jogadorService.findAll().isEmpty()) {
            List<JogadorCartolaDTO> jogadorCartolaDTOS = jogadorCartolaClient.listarJogadores();
            // TODO Refatorar busca de clubes, para não ir no banco de dados dentro do loop
            List<Clube> finalClubes = clubes;
            List<Jogador> jogadores = jogadorCartolaDTOS
                    .stream()
                    .map(jogador -> {
                        return new Jogador(
                                jogador.getId(),
                                jogador.getStatusId(),
                                jogador.getPreco(),
                                jogador.getNome(),
                                jogador.getFoto(),
                                jogador.getApelido(),
                                jogador.getMedia(),
                                0l,
                                getClubeById(jogador.getClubeId(), finalClubes),
                                jogador.getPosicaoId()
                        );
                    }).collect(Collectors.toList());
            jogadorService.saveAll(jogadores);
        }

        if (posicaoService.findAll().isEmpty()) {
            List<Posicao> posicoes = List.of(
                    new Posicao(1l, "Goleiro", "gol"),
                    new Posicao(2l, "Zagueiro", "zag"),
                    new Posicao(3l, "Lateral", "lat"),
                    new Posicao(4l, "Meia", "mei"),
                    new Posicao(5l, "Atacante", "ata"),
                    new Posicao(6l, "Técnico", "tec")
            );
            posicaoService.saveAll(posicoes);
        }
    }

    private Clube getClubeById(Long clubeId, List<Clube> clubes) {
        return clubes.stream().filter(clube -> Objects.equals(clube.getId(), clubeId))
                .collect(Collectors.toList()).get(0);
    }
}
