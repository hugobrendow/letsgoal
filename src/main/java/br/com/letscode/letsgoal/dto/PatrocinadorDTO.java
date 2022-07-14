package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Patrocinador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatrocinadorDTO {
    private Long id;
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    private String nome;

    public PatrocinadorDTO(Patrocinador patrocinador){
        id = patrocinador.getId();
        descricao = patrocinador.getDescricao();
        urlLink = patrocinador.getUrlLink();
        imagemMarca = patrocinador.getImagemMarca();
        nome = patrocinador.getNome();
    }
}
