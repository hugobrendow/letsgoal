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
    private Clube clubeCasa;
    private Clube clubeVisitante;
    private LocalDate dataPartida;
    private String local;
    private String rodada;
    private Integer placarMandante;
    private Integer placarVisitante;

}
