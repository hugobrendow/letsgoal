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
    private String clubeCasa;
    private String clubeVisitante;
    private LocalDate dataPartida;
    private String Local;
    private Integer rodada;
    private Integer placarMandante;
    private Integer placarVisitante;
}
