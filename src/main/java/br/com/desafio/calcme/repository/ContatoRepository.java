package br.com.desafio.calcme.repository;

import br.com.desafio.calcme.domain.Contato;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContatoRepository extends MongoRepository<Contato, String> {

}