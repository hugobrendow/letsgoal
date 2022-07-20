package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
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
