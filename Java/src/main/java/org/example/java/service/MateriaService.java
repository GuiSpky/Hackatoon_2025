package org.example.java.service;

import org.example.java.model.Aluno;
import org.example.java.model.Materia;
import org.example.java.repository.AlunoRepository;
import org.example.java.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired// Injeta dependência automaticamente
    private MateriaRepository repository;

    // Salvar o médico
    public void salvar(Materia materia) {
        repository.save(materia);
    }

    // Listar todos os médicos
    public List<Materia> listarTodos() {
        return repository.findAll();
    }

    // Busca o cadastro do médico através do id
    public Materia buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    // Deletar o médico
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
