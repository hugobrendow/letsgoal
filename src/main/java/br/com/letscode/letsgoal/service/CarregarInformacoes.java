package br.com.letscode.letsgoal.service;


import br.com.letscode.letsgoal.cartola.client.ClubeCartolaClient;
import br.com.letscode.letsgoal.cartola.dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.EscudoCartolaDTO;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CarregarInformacoes implements ApplicationRunner {

    ClubeService clubeService;
    ClubeCartolaClient clubeCartolaClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (clubeService.listar().isEmpty()) {
            List<ClubeCartolaDTO> clubeCartolaDTO = clubeCartolaClient.listarClubes();
            List<Clube> clubes = clubeCartolaDTO
                    .stream()
                    .map(objeto -> {
                        EscudoCartolaDTO escudoDTO = objeto.getEscudo();
                        Escudo escudo = new Escudo();
                        BeanUtils.copyProperties(escudoDTO, escudo);
                        return new Clube(
                                null,
                                objeto.getNome(),
                                objeto.getAbreviacao(),
                                objeto.getNomeFantasia(),
                                escudo);
                    }).collect(Collectors.toList());
            clubeService.salvarTodos(clubes);
        }

        // TODO implementar a regra para salvar jogadores
    }
}