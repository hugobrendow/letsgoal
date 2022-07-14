package br.com.letscode.letsgoal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Descrição é obrigatório")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "casa_id")
    private Clube casa;
    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Clube visitante;
    private Date partida;
    private String local;
    private Integer rodada;
    private String placarMandante;
    private String placarVisitante;
}
