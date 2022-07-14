package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "table_shield")
public class Escudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sessentaPorSessenta;
    private String quarentaCincoPorQuarentaCinco;
    private String trintaPorTrinta;
}
