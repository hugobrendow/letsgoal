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
public class LetsClube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoClub;
    @OneToOne
    private Formacao formacao;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Patrocinador> patrocinadores;
}
