package br.com.letscode.letsgoal.DTO.FormacaoDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoResponseDTO {

    private Long id;
    private String nome;
}