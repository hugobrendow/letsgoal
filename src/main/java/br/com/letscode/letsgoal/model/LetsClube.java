package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LetsClube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Descrição é obrigatório")
    private Long id;
    @Column(unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "formacao_id")
    private Formacao formacao;
}
