package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Descrição é obrigatório")
    private Long id;
    @Column(unique = true)
    private String nome;

    @ManyToMany
    @JoinTable(name = "tb_posicao_formacao",joinColumns = @JoinColumn(name = "posicao_id"),
            inverseJoinColumns = @JoinColumn(name = "formacao_id" ))
    private List<Posicao> posicoes;

}
