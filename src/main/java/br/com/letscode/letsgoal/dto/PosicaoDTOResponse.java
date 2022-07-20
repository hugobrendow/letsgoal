package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PosicaoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Jogador jogador;
}
