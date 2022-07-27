package br.com.letscode.letsgoal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "table_player")
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {
    @Id
    private Long id;
    private Long status;
    private BigDecimal price;
    private String nome;
    private String foto;
    private String apelido;
    private Long mediaDePontos;
    private Long totalDePontos;
    private Long posicao;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;
}
