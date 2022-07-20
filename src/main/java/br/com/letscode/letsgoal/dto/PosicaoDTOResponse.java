package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Jogador;
import lombok.*;

import java.io.Serializable;

@Data
public class PosicaoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Jogador jogador;
}
