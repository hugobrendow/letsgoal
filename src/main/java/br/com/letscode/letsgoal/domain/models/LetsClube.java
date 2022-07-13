package br.com.letscode.letsgoal.domain.models;

import lombok.Data;

@Data
public class LetsClube {

    private Long id;
    private String nome;
    private Formacao formacao;
}
