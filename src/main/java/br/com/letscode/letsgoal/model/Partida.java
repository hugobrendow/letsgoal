package br.com.letscode.letsgoal.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Partida {
    private Long id;
    private Clube clubeCasa;
    private Clube clubeVisitante;
    private LocalDate data;
    private String local;
    private Double rodada;
    private Double placarMandante;
    private Double placarVisitante;
}
