package org.example.java.service;

import org.example.java.model.Aluno;
import org.example.java.model.Prova;
import org.example.java.repository.AlunoRepository;
import org.example.java.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {


    @Autowired// Injeta dependência automaticamente
    private ProvaRepository repository;

    // Salvar o médico
    public void salvar(Prova prova) {
        repository.save(prova);
    }

    // Listar todos os médicos
    public List<Prova> listarTodos() {
        return repository.findAll();
    }

    // Busca o cadastro do médico através do id
    public Prova buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    // Deletar o médico
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
