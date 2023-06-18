package br.com.desafio.calcme.service;

import br.com.desafio.calcme.domain.Contato;
import br.com.desafio.calcme.dto.ContatoDTO;
import br.com.desafio.calcme.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private  ContatoRepository contatoRepository;

    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> buscarContatoPorId(String id) {
        return contatoRepository.findById(id);
    }

    public Contato criarContato(ContatoDTO contatoDTO) {

        return contatoRepository.save(saveContato(contatoDTO));
    }

    public Optional<Contato> atualizarContato(String id, ContatoDTO contatoDTO) {
        Optional<Contato> optionalContato = contatoRepository.findById(id);
        if (optionalContato.isPresent()) {
            Contato contato = saveContato(contatoDTO);
            contato.setId(optionalContato.get().getId());
            return Optional.of(contatoRepository.save(contato));
        }
        return Optional.empty();
    }

    private Contato saveContato(ContatoDTO contatoDTO) {
        return Contato.builder()
                .nome(contatoDTO.getNome())
                .email(contatoDTO.getEmail())
                .telefone(contatoDTO.getTelefone())
                .build();
    }

    public void excluirContato(String id) {
        contatoRepository.deleteById(id);
    }

}