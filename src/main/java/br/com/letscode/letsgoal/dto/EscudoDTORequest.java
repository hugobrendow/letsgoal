package br.com.letscode.letsgoal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class EscudoDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String img60x60;
    @NotBlank
    private String img45x45;
    @NotBlank
    private String img30x30;
}
