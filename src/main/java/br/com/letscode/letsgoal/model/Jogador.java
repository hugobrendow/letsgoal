package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Descrição é obrigatório")
    private Long id;
    private String status;
    private BigDecimal preco;
    private Double mediaPontos;
    private Integer totalJogos;
    private String apelido;
    @Column(unique = true)
    private String nome;
    private String foto;
}
