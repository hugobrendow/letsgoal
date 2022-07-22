package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long status;
    private BigDecimal preco;
    private Long mediaDePontos;
    private Long totalDeJogos;
    private String apelido;
    private String nome;
    private String foto;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clube_id",referencedColumnName = "id", nullable = false)
    private Clube clube;



}
