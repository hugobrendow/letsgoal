package br.com.letscode.letsgoal.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partida")
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "clube_casa_id", referencedColumnName = "id")
    private Clube clubeCasa;
    @OneToOne
    @JoinColumn(name = "clube_visitante_id", referencedColumnName = "id")
    private Clube clubeVisitante;
    private LocalDate dataPartida;
    private String local;
    private String rodada;
    private Integer placarMandante;
    private Integer placarVisitante;

}
