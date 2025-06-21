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

    @Autowired
    private ProvaRepository provaRepository;

    public void salvar(Prova prova) {
        provaRepository.save(prova); // já salva com perguntas em cascade
    }

    public List<Prova> listarTodos() {
        return provaRepository.findAll();
    }

    public void deletarPorId(Long id) {
        provaRepository.deleteById(id);
    }

    public Prova buscarPorId(Long id) {
        return provaRepository.findById(id).orElse(null);
    }
}

