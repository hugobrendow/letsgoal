package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.cartola.Dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.Dto.EscudoCartolaDTO;
import br.com.letscode.letsgoal.cartola.Dto.JogadorCartolaDTO;
import br.com.letscode.letsgoal.cartola.client.ClubeCartolaClient;
import br.com.letscode.letsgoal.cartola.client.FormacaoCartolaClient;
import br.com.letscode.letsgoal.cartola.client.JogadorCartolaClient;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CarregarInformacoes implements ApplicationRunner {

    ClubeCartolaClient clubeCartolaClient;
    ClubeService clubeService;
    JogadorCartolaClient jogadorCartolaClient;
    FormacaoCartolaClient formacaoCartolaClient;
    JogadorService jogadorService;
    PosicaoService posicaoService;
    FormacaoService formacaoService;
    ModelMapper modelMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(clubeService.findAll().isEmpty()){
            List<ClubeCartolaDTO> clubeCartolaDTOS = clubeCartolaClient.listarClubes();
            List<Clube> clubes = clubeCartolaDTOS.stream()
                    .map(clube -> {
                        EscudoCartolaDTO escudoCartolaDTO = clube.getEscudo();
                        var escudo = new Escudo();
                        modelMapper.map(escudoCartolaDTO, escudo);

                        return new Clube(
                                clube.getId(),
                                clube.getNome(),
                                clube.getNomeFantasia(),
                                escudo
                        );
                    })
                    .collect(Collectors.toList());
            clubeService.saveClubes(clubes);
        }
        if (jogadorService.findAll().isEmpty()) {
            List<JogadorCartolaDTO> jogadorCartolaDTOS = jogadorCartolaClient.listarJogadores();
            // TODO Refatorar busca de clubes, para não ir no banco de dados dentro do loop
            List<Jogador> jogadores = jogadorCartolaDTOS
                    .stream()
                    .map(jogador -> {
                        return new Jogador(
                                jogador.getId(),
                                jogador.getStatusId(),
                                jogador.getPreco(),
                                jogador.getMedia(),
                                0,
                                jogador.getNome(),
                                jogador.getFoto(),
                                jogador.getApelido(),


                                clubeService.findById(jogador.getClubeId()),
                                jogador.getPosicaoId()
                        );
                    }).collect(Collectors.toList());
            jogadorService.saveJogadores(jogadores);
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
            posicaoService.saveFormacoes(posicoes);
        }

        if(formacaoService.findAll().isEmpty()){
            formacaoCartolaClient.listarFormacoes();
        }
    }
}
