package br.com.letscode.letsgoal.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class JogadorDto {

    @NotEmpty
    private Long status;
    @NotEmpty
    private BigDecimal price;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String foto;
    @NotEmpty
    private String apelido;
    @NotEmpty
    private Long mediaDePontos;
    @NotEmpty
    private Long totalDePontos;



}
