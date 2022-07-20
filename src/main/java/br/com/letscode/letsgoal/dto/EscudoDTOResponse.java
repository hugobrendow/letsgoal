package br.com.letscode.letsgoal.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class EscudoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String img60x60;
    private String img45x45;
    private String img30x30;
}
