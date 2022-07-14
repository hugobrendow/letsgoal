package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "table_shield")
public class Escudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String sessentaPorSessenta;
    @Column(nullable = false)
    private String quarentaCincoPorQuarentaCinco;
    @Column(nullable = false)
    private String trintaPorTrinta;
}
