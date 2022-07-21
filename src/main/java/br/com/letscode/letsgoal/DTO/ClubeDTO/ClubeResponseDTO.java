package br.com.letscode.letsgoal.DTO.ClubeDTO;

import br.com.letscode.letsgoal.DTO.EscudoDTO.EscudoResponseDTO;
import br.com.letscode.letsgoal.model.Escudo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubeResponseDTO {

    private Long id;
    private String nomeDoClube;
    private String abreviacao;
    private EscudoResponseDTO escudos;
}

