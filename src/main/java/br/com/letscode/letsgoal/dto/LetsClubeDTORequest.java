package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class LetsClubeDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String formacao;
    private Set<String> patrocinadores;
    private Set<String> jogadores;
}
