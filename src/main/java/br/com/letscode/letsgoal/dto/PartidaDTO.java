package br.com.letscode.letsgoal.dto;

import br.com.letscode.letsgoal.model.Clube;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {
    @NotNull
    private Clube casa;
    @NotNull
    private Clube visitante;
    @NotNull
    private Date partida;
    @NotBlank
    private String local;
    @NotNull
    private Integer rodada;
    @NotBlank
    private String placarMandante;
    @NotBlank
    private String placarVisitante;
}

