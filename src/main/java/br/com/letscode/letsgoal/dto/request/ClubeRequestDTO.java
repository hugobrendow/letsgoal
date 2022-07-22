package br.com.letscode.letsgoal.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ClubeRequestDTO {
    @NotBlank
    private String nomeDoClube;
    @NotBlank
    @Pattern(regexp = ("^[a-zA-Z]{3,}$"))
    private String abreviacao;
    @NotBlank
    private String nomeFantasia;
    @NotNull
    private EscudoRequestDTO escudo;
}
