package org.example.java.service;

import org.example.java.model.Aluno;
import org.example.java.model.Turma;
import org.example.java.repository.AlunoRepository;
import org.example.java.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
public class TurmaService {

    @Autowired// Injeta dependência automaticamente
    private TurmaRepository repository;

    // Salvar o médico
    public void salvar(Turma turma) {
        repository.save(turma);
    }

    // Listar todos os médicos
    public List<Turma> listarTodos() {
        return repository.findAll();
    }

    // Busca o cadastro do médico através do id
    public Turma buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    // Deletar o médico
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
