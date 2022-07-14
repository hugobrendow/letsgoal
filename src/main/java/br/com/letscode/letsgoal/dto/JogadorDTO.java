package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO {
    private Long id;
    private String status;
    private Double preco;
    private Double mediaDePontos;
    private Integer totalDeJogos;
    private String apelido;
    private String nome;
    private String foto;

    public JogadorDTO(Jogador jogador){
        id = jogador.getId();
        status = jogador.getStatus();
        preco = jogador.getPreco();
        mediaDePontos = jogador.getMediaDePontos();
        totalDeJogos = jogador.getTotalDeJogos();
        apelido = jogador.getApelido();
        nome = jogador.getNome();
        foto = jogador.getFoto();
    }
}
