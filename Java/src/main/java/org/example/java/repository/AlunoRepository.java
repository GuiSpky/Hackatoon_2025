package org.example.java.repository;

import org.example.java.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
