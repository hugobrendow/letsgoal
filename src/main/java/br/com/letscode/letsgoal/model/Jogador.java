package br.com.letscode.letsgoal.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal preco;
    private String nome;
    private String apelido;
    private String foto;
    private Long media;
    private Long totalJogos;
    private Long status;

    /*
        Nesta relação estamos tratando:
            1 Clube pode ter 0 ou N jogadores
            e 1 Jogador pode ter apenas 1 Clube

        optional = false
            Significa que é obrigatório o jogador ter um clube

        nullable = false
            Significa que o clube não pode ser um valor null
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;
}
