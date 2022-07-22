package br.com.letscode.letsgoal.cartola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorCartolaDTO {
    private Long id;
    private Long clubeId;
    private Long posicaoId;
    private Long statusId;
    private BigDecimal preco;
    private Long media;
    private String slug;
    private String apelido;
    private String apelidoAbreviado;
    private String nome;
    private String foto;
}