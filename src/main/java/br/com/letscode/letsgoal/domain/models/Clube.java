package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

import java.util.List;

@Data
public class Clube {

    private Long id;
    private String nome;
    private String abreviacao;
    private List<Escudo> escudos;
    private String nomeFantasia;
}
