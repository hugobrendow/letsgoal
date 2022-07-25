package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    //    @ManyToMany
//    @JoinTable(name = "tb_posicao_formacao", joinColumns = @JoinColumn(name = "posicao_id"),
//            inverseJoinColumns = @JoinColumn(name = "formacao_id"))

    @OneToMany
    @JoinColumn(name="posicao_id", referencedColumnName="id")
    private List<Posicao> posicoes;

}
