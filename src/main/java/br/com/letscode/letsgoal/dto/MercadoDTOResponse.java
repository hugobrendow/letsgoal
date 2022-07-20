package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class MercadoDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String status;

}
