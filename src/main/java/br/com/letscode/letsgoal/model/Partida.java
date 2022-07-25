package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clubeCasa_id", referencedColumnName = "id")
    Clube casa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clubeVisitante_id", referencedColumnName = "id")
    Clube visitante;
    LocalDate partida;
    String local;
    Integer rodada;
    Integer placarMandante;
    Integer placarVisitante;

}
