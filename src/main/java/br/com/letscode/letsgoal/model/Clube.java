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
public class Clube {
    @Id
    private Long id;
    private String nomeDoClube;
    private String abreviacao;
    private String nomeFantasia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "escudo_id", referencedColumnName = "id")
    private Escudo escudos;
}
