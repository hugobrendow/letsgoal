package br.com.letscode.letsgoal.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Escudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho60x60;
    private String tamanho45x45;
    private String tamanho30x30;
}
