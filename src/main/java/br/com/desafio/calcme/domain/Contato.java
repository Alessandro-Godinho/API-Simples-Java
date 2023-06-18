package br.com.desafio.calcme.domain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contatos")
@Data
@Builder
public class Contato {

    @Id
    private String id;
    private String nome;
    private String email;
    private String telefone;

}
