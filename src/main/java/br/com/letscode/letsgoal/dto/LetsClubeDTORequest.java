package br.com.letscode.letsgoal.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class LetsClubeDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String formacao;
    private Set<String> patrocinadores;
    private Set<String> jogadores;
}
