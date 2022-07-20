package br.com.letscode.letsgoal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class MercadoDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;
}
