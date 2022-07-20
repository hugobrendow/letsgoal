package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ClubeDTO implements Serializable {
    @NotBlank
    private String nome;
    @NotBlank
    private String abreviacao;
    @NotBlank
    private String nomeFantasia;
    @NotNull
    private EscudoDTO escudo;
}
