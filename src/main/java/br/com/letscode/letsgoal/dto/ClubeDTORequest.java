package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Data
public class ClubeDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String nome;
    @NotBlank
    private String abrevicao;
    @NotBlank
    private String escudos;
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    private Set<String> jogadores;
}
