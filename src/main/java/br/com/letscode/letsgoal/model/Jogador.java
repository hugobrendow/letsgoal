package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {

    @Id
    private Long id;
    private Long Status;
    private BigDecimal preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    private String apelido;
    private String nome;
    private String urlFoto;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;
    private Long posicao;
}
