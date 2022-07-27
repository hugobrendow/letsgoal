package br.com.letscode.letsgoal.domain.services;

import br.com.letscode.letsgoal.cartola.client.ClubeCartolaClient;
import br.com.letscode.letsgoal.cartola.client.FormacaoCartolaClient;
import br.com.letscode.letsgoal.cartola.client.JogadorCartolaClient;
import br.com.letscode.letsgoal.cartola.client.PatrocinadorCartolaClient;
import br.com.letscode.letsgoal.cartola.dto.*;
import br.com.letscode.letsgoal.domain.models.*;
import br.com.letscode.letsgoal.domain.services.interfaces.*;
import br.com.letscode.letsgoal.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LoadDatabaseInformation implements ApplicationRunner {

    private ClubeCartolaClient clubeCartolaClient;
    private JogadorCartolaClient jogadorCartolaClient;
    private PatrocinadorCartolaClient patrocinadorCartolaClient;
    private FormacaoCartolaClient formacaoCartolaClient;
    private ClubeService clubeService;
    private JogadorService jogadorService;
    private PosicaoService posicaoService;
    private PatrocinadorService patrocinadorService;
    private FormacaoService formacaoService;




    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<ClubeCartolaDTO> clubeCartolaDTOS = clubeCartolaClient.listarClubes();

        if(clubeService.findAll().isEmpty()){
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

            clubeService.saveAll(clubes);
        }

        if(jogadorService.findAll().isEmpty()) {
            List<JogadorCartolaDTO> jogadorCartolaDTOS = jogadorCartolaClient.listarJogadores();
            Set<Clube> clubes = new HashSet<>(clubeService.findAll());

            List<Jogador> jogadores = jogadorCartolaDTOS.stream()
                    .map(player ->
                            new Jogador(
                                    player.getId(),
                                    player.getStatusId(),
                                    player.getPreco(),
                                    player.getNome(),
                                    player.getFoto(),
                                    player.getApelido(),
                                    player.getMedia(),
                                    0l,
                                    player.getPosicaoId(),
                                    clubes.stream()
                                            .filter(club -> club.getId().equals(player.getClubeId()))
                                            .findFirst().orElseThrow(() -> new ResourceNotFoundException(player.getClubeId()))
                            )
                    ).collect(Collectors.toList());
            jogadorService.saveAll(jogadores);
        }

        if (posicaoService.findAll().isEmpty()) {
            List<Posicao> posicoes = List.of(
                    new Posicao(1L, "Goleiro", "gol"),
                    new Posicao(2L, "Zagueiro", "zag"),
                    new Posicao(3L, "Lateral", "lat"),
                    new Posicao(4L, "Meia", "mei"),
                    new Posicao(5L, "Atacante", "ata"),
                    new Posicao(6L, "Técnico", "tec")
            );
            posicaoService.saveAll(posicoes);
        }

        if(patrocinadorService.findAll().isEmpty()){
            List<PatrocinadorCartolaDTO> patrocinadorCartolaDTOS = patrocinadorCartolaClient.listarPatrocinadores();

            List<Patrocinador> patrocinadors = patrocinadorCartolaDTOS.stream()
                    .map(patrocinador ->
                            new Patrocinador(
                                    patrocinador.getId(),
                                    patrocinador.getNome(),
                                    patrocinador.getDescricao(),
                                    patrocinador.getUrlLink(),
                                    patrocinador.getImage()
                            )).collect(Collectors.toList());
            patrocinadorService.saveAll(patrocinadors);
        }

        if (formacaoService.findAll().isEmpty()){
            List<FormacaoCartolaDTO> formacaoCartolaDTOS = formacaoCartolaClient.listarFormacao();
            List<Formacao> formacaos = formacaoCartolaDTOS.stream()
                    .map(formacao->
                            new Formacao(
                                    formacao.getId(),
                                    formacao.getNome(),
                                    converterPosicoes(formacao.getPosicaos())
                            )).collect(Collectors.toList());
            formacaoService.saveAll(formacaos);
        }
    }

    private List<Posicao> converterPosicoes(List<PosicaoCartolaDTO> posicaoCartolaDTOS) {
        List<Posicao> posicoes = new ArrayList<>();

        posicaoCartolaDTOS.forEach( obj -> {
            String abreviacao = obj.getAbreviacao();
            long quantity = obj.getQuantity();
            for (int i = 0; i < quantity; i++) {
                Posicao posicao = posicaoService.findByAbreviacao(abreviacao);
                posicoes.add(posicao);
            }
        });
        return posicoes;
    }
}
