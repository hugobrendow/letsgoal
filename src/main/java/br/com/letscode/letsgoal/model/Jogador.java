package br.com.letscode.letsgoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Double preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    private String apelido;
    private String nome;
    private String urlFoto;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "clube_id")
    private Clube clube;
    @JsonIgnore
    @OneToOne
    private Posicao posicao;

}
