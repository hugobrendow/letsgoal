package br.com.letscode.letsgoal.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class MercadoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String status;

}
