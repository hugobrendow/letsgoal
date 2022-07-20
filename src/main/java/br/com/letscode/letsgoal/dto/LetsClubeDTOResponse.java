package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Jogador;
import br.com.letscode.letsgoal.model.Patrocinador;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
public class LetsClubeDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Formacao formacao;
    private Set<Patrocinador> patrocinadores;
    private Set<Jogador> jogadores;

}
