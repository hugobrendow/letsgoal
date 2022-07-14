package br.com.letscode.letsgoal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Escudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Descrição é obrigatório")

    private String tamanho60x60;
    private String tamanho45x45;
    private String tamanho30x30;
    @ManyToOne
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;

}
