package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    Long id;
    Clube clubeCasa;
    Clube clubeVisitante;
    LocalDate dataPartida;
    String local;
    int rodada;
    int placarMandante;
    int placarVisitante;
}
