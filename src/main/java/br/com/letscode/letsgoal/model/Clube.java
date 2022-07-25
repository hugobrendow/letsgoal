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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeClube;
    private String abreviacao;
    private String nomeFantasia;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "name_id",referencedColumnName = "id")
    private Escudo escudo;
}
