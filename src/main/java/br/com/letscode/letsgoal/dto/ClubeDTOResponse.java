package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ClubeDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String abrevicao;
    private Escudo escudos;
    private String nomeFantasia;
    private Set<Jogador> jogadores;
}
