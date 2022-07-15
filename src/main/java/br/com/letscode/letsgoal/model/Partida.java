package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Clube clubeCasa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Clube clubeVisitante;
    
    private LocalDateTime dataPartida;
    private LocalTime local;
    private Integer rodada;
    private int PlacarMandante;
    private int PlacarVisitante;
}
