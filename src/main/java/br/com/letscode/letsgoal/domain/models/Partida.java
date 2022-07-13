package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Partida {

    private Long id;
    private Clube casa;
    private Clube visitante;
    private LocalDate dataPartida;
    private String local;
    private int rodada;
    private int placarMandante;
    private int placarVisitante;
}
