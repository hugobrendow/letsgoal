package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    private Long id;
    private Clube clubeDaCasa;
    private Clube clubeVisitante;
    private LocalDate dataPartida;
    private String local;
    private int rodada;
    private int placarMandante;
    private int placarVisitante;
}
