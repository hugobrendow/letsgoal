package br.com.letscode.letsgoal.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class JogadorRequestDTO {
    @NotBlank
    private Long status;
    @NotBlank
    private BigDecimal preco;
    @NotBlank
    private Long mediaDePontos;
    @NotBlank
    private Long totalDeJogos;
    @NotBlank
    private String apelido;
    @NotBlank
    private String nome;
    @NotBlank
    private String foto;
    @NotNull
    private ClubeRequestDTO clube;
}
