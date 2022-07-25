package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public class LetsClube {
        @Id
        public Long id;
        public String nome;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "formacao_id", referencedColumnName = "id")
        public Formacao formacao;

        @Transient
        List<Jogador> jogadores;

}
