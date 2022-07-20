package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class EscudoDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String img60x60;
    @NotBlank
    private String img45x45;
    @NotBlank
    private String img30x30;
}
