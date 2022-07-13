package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "clube_casa_id")
    private Clube clubeCasa;
    @OneToOne
    @JoinColumn(name = "clube_visitante_id")
    private Clube clubeVisitante;
    private LocalDateTime dataPartida;
    private String local;
    private int rodada;
    private int placarMandante;
    private int placarVisitante;
}
