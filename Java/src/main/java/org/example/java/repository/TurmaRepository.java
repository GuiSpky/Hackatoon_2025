package org.example.java.repository;

import org.example.java.model.Aluno;
import org.example.java.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
