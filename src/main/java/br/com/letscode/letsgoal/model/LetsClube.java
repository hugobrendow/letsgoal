package br.com.letscode.letsgoal.model;


import lombok.Data;


@Data
public class LetsClube {
    private Long id;
    private String nomeDoClube;
    private Formacao formacao;
}
