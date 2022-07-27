package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class JogadorDTO {
    @NotBlank
    private Long status;
    @NotBlank
    private BigDecimal preco;
    @NotBlank
    private Long media;
    @NotBlank
    private Long totalDeJogos;
    @NotBlank
    private String apelido;
    @NotBlank
    private String nome;
    @NotBlank
    private String foto;
    @NotNull
    private Clube clube;
    @NotBlank
    private Long posicao;
}
