package br.com.letscode.letsgoal.DTO.FormacaoDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoRequestDTO {

    private String nome;
}
