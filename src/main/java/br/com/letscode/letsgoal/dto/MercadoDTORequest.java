package br.com.letscode.letsgoal.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MercadoDTORequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;
}
