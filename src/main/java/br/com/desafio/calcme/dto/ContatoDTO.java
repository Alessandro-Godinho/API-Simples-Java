package br.com.desafio.calcme.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContatoDTO {

    private String id;
    private String nome;
    private String email;
    private String telefone;

}