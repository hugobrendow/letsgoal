package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
public class FormacaoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private List<Posicao> posicoes;
}
