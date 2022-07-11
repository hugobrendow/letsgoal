package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {

    private Long Id;
    private String status;
    private BigDecimal preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    private String apelido;
    private String nome;
    private String foto;

}
