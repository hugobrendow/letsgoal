package br.com.letscode.letsgoal.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormacaoDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private List<String> posicoes;
}
