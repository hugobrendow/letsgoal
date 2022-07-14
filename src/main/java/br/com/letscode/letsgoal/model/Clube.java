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
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Descrição é obrigatório")
    private Long id;
    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "clube")
    private List<Escudo> escudos;
    private String nomeFantasia;
}
