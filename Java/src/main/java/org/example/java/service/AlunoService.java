package org.example.java.service;

import org.example.java.model.Aluno;
import org.example.java.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
public class AlunoService {

    @Autowired// Injeta dependência automaticamente
    private AlunoRepository repository;

    // Salvar o médico
    public void salvar(Aluno aluno) {
        repository.save(aluno);
    }

    // Listar todos os médicos
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // Busca o cadastro do médico através do id
    public Aluno buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    // Deletar o médico
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    public List<Aluno> listarAlunosPorTurmaId(Long turmaId) {
        // A implementação real aqui dependerá de como seu modelo Aluno se relaciona com Turma.
        // Se Aluno tem um campo 'turma' que é um objeto Turma, e Turma tem um 'id',
        // você pode usar o Spring Data JPA para criar um método de consulta.
        return repository.findByTurmaId(turmaId); // Exemplo de método no repositório
    }
}
