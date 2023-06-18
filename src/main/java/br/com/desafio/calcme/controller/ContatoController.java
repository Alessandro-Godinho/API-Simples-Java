package br.com.desafio.calcme.controller;

import br.com.desafio.calcme.domain.Contato;
import br.com.desafio.calcme.dto.ContatoDTO;
import br.com.desafio.calcme.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
@CrossOrigin(origins = "*")

public class ContatoController {
    @Autowired
    private  ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatos() {
        List<Contato> contatos = contatoService.listarContatos();
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarContatoPorId(@PathVariable String id) {
        Optional<Contato> optionalContato = contatoService.buscarContatoPorId(id);
        return optionalContato.map(contato -> new ResponseEntity<>(contato, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody ContatoDTO contatoDTO) {
        Contato contato = contatoService.criarContato(contatoDTO);
        return new ResponseEntity<>(contato, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable String id, @RequestBody ContatoDTO contatoDTO) {
        Optional<Contato> optionalContato = contatoService.atualizarContato(id, contatoDTO);
        return optionalContato.map(contato -> new ResponseEntity<>(contato, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable String id) {
        contatoService.excluirContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}