package br.com.letscode.letsgoal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String abreviacao;
    private String nomeFantasia;

    /*
        Nesta relação, 1 clube pode ter apenas 1 objeto de escudo. E escudo só pode ter um clube

        @JoinColumn
            name = Definimos o nome da coluna que cuidará da relação entre Clube x Escudo
            referencedColumnName = é o nome da coluna da chave do escudo que irá relacionar com o Clube

        RELAÇÃO UNIDIRECIONAL

        ###############################################
        PARA UMA RELAÇÃO BIDIRECIONAL:
            DEVE SER ADICIONADO NO OBJETO DO ESCUDO

            @OneToOne(mappedBy = "escudo")
            private Clube clube;
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "escudo_id", referencedColumnName = "id")
    private Escudo escudo;

    /*
        BIDIRECIONAL

        Nesta relação estamos tratando:
            1 Clube pode ter 0 ou N jogadores
            e 1 Jogador pode ter apenas 1 Clube

        mappedBy = se refere ao atributo da Classe Jogador onde está o relacionamento
        fetch = EAGER OU LAZY
            Por padrão o fetch é Lazy.

            Carregamento EAGER = este atributo faz com que no momento do carregamento do clube os jogadores já sejam carregados
            Carregamento LAZY = conhecido como carregamento preguiçoso, a informação só é carregada quando você precisa


        UNIDIRECIONAL

        orphanRemoval = true
            Significa que caso o Clube seja removido os jogadores podem ser removido também

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
        @JoinColumn(name = "clube_id")

    @OneToMany(mappedBy = "clube", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jogador> jogadores;*/
}
