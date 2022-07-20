package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Posicao;
import lombok.*;

import java.io.Serializable;

@Data
public class JogadorDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String status;
    private Double preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    private String apelido;
    private String nome;
    private String urlFoto;
    private Clube clube;
    private Posicao posicao;
}
