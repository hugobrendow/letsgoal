package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.cartola.client.ClubeCartolaClient;
import br.com.letscode.letsgoal.cartola.client.FormacaoCartolaClient;
import br.com.letscode.letsgoal.cartola.client.JogadorCartolaClient;
import br.com.letscode.letsgoal.cartola.dto.*;
import br.com.letscode.letsgoal.model.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CarregarInformacoes implements ApplicationRunner {
    ClubeCartolaClient clubeCartolaClient;
    ClubeService clubeService;
    JogadorCartolaClient jogadorCartolaClient;
    JogadorService jogadorService;
    PosicaoService posicaoService;

    FormacaoCartolaClient formacaoCartolaClient;
    FormacaoService formacaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<ClubeCartolaDTO> clubeCartolaDTOS = clubeCartolaClient.listarClubes();
        // TODO Comparar informações e atualizar
        if (clubeService.listar().isEmpty()) {
            List<Clube> clubes = clubeCartolaDTOS
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

            clubeService.salvarClubes(clubes);
        }

        // TODO Comparar informações e atualizar
        if (jogadorService.listar().isEmpty()) {
            List<JogadorCartolaDTO> jogadorCartolaDTOS = jogadorCartolaClient.listarJogadores();
            // TODO Refatorar busca de clubes, para não ir no banco de dados dentro do loop
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
                                clubeService.buscaPorId(jogador.getClubeId()),
                                jogador.getPosicaoId()
                        );
                    }).collect(Collectors.toList());
            jogadorService.salvarJogadores(jogadores);
        }

        if (formacaoService.listar().isEmpty()) {
            List<FormacaoCartolaDTO> formacaoCartolaDTOS = formacaoCartolaClient.listarFormacoes();
            List<Formacao> formacoes = formacaoCartolaDTOS
                    .stream()
                    .map(objeto -> {
                        List<PosicaoCartolaDTO> posicoesDTO = objeto.getPosicoesCartolaDTO();
                        List<Posicao> posicoes = Arrays.asList();
                        BeanUtils.copyProperties(posicoesDTO, posicoes);

                        return new Formacao(
                                objeto.getId(),
                                objeto.getNome(),
                                posicoes
                        );
                    }).collect(Collectors.toList());

            formacaoService.salvarFormacoes(formacoes);
        }

        if (posicaoService.listar().isEmpty()) {
            List<Posicao> posicoes = List.of(
                    new Posicao(1l, "Goleiro", "gol"),
                    new Posicao(2l, "Zagueiro", "zag"),
                    new Posicao(3l, "Lateral", "lat"),
                    new Posicao(4l, "Meia", "mei"),
                    new Posicao(5l, "Atacante", "ata"),
                    new Posicao(6l, "Técnico", "tec")
            );
            posicaoService.salvarPosicoes(posicoes);
        }
    }
}
