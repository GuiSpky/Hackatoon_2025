package org.example.java.service;

import org.example.java.model.ItemPergunta;
import org.example.java.model.Prova;
import org.example.java.repository.ItemPerguntaRepository;
import org.example.java.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPerguntaService {

    @Autowired// Injeta dependência automaticamente
    private ItemPerguntaRepository repository;

    // Salvar o médico
    public void salvar(ItemPergunta pergunta) {
        repository.save(pergunta);
    }

    // Listar todos os médicos
    public List<ItemPergunta> listarTodos() {
        return repository.findAll();
    }

    // Busca o cadastro do médico através do id
    public ItemPergunta buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    // Deletar o médico
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
