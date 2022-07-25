package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jogador {
    @Id
    private Long id;
    private Long status;
    private BigDecimal preco;
    private String nome;
    private String foto;
    private String apelido;
    private Long media;
    private Long totalJogos;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;
    private Long posicao;
}
