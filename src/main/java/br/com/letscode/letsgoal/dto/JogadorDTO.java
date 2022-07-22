package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO {
    @NotBlank
    private String status;
    private BigDecimal preco;
    @NotBlank
    private String nome;
    private String foto;
    private String apelido;
    private Long media;
    private Long totalJogos;
    @NotNull
    private Clube clube;
}