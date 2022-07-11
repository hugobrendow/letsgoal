package br.com.letscode.letsgoal.model;

import java.time.LocalDateTime;

public class Partida {

    private Long id;
    private Clube clubeCasa;
    private Clube clubeVisitante;
    private LocalDateTime dataPartida;
    private String local;
    private int rodada;
    private int placarMandante;
    private int placarVisitante;
}
