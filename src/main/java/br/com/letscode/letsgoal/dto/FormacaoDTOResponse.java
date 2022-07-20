package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Posicao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FormacaoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private List<Posicao> posicoes;
}
