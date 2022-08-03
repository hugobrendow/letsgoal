package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;
    private Long posicao;

    @ManyToMany
    private List<LetsClube> letsClubes;
}
