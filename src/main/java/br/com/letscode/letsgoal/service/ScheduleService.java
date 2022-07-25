package br.com.letscode.letsgoal.service;


import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    public boolean isScheduleValid(LetsClube letsClube) {
        return isQtdAtacanteValid(letsClube) &&
                isQtdDefensoresValid(letsClube) &&
                isQtdMeioCampoValid(letsClube);
    }

    private boolean isQtdAtacanteValid(LetsClube letsClube) {
        return getQtdAtacantes(letsClube.getFormacao().getPosicoes())
                .equals(getQtdAtacantesJogador(letsClube.getJogadores()));
    }

    private boolean isQtdDefensoresValid(LetsClube letsClube) {
        return getQtdDefensores(letsClube.getFormacao().getPosicoes())
                .equals(getQtdDefensoresJogador(letsClube.getJogadores()));
    }

    private boolean isQtdMeioCampoValid(LetsClube letsClube) {
        return getQtdMeioCampo(letsClube.getFormacao().getPosicoes())
                .equals(getQtdMeioCampoJogador(letsClube.getJogadores()));
    }


    private Long getQtdAtacantes(List<Posicao> posicoes) {
        return getQtdPosicao("ata", posicoes);
    }

    private Long getQtdDefensores(List<Posicao> posicoes) {
        return getQtdPosicao("zag", posicoes) + getQtdPosicao("lat", posicoes);
    }

    private Long getQtdMeioCampo(List<Posicao> posicoes) {
        return getQtdPosicao("mei", posicoes);
    }

    private Long getQtdPosicao(String abreviacao, List<Posicao> posicoes) {
        return posicoes.stream().filter(posicao -> abreviacao.equals(posicao.getAbreviacao())).count();
    }


    private Long getQtdAtacantesJogador(List<Jogador> jogadores) {
        return getQtdPosicaoJogador(5L, jogadores);
    }

    private Long getQtdDefensoresJogador(List<Jogador> jogadores) {
        return getQtdPosicaoJogador(3L, jogadores) + getQtdPosicaoJogador(2L, jogadores);
    }

    private Long getQtdMeioCampoJogador(List<Jogador> jogadores) {
        return getQtdPosicaoJogador(4L, jogadores);
    }

    private Long getQtdPosicaoJogador(Long posicao, List<Jogador> jogadores) {
        return jogadores.stream().filter(jogador -> posicao.equals(jogador.getPosicao())).count();
    }

}
