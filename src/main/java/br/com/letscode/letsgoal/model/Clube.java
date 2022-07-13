package br.com.letscode.letsgoal.model;

import lombok.Data;


import javax.persistence.Embeddable;

@Data
@Embeddable
public class Clube {
    private Long id;
    private String nome;
    private String abrviacao;
    private Escudo[] escudos;
    private String nomeFantasia;
}
