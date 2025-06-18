package org.example.java.repository;

import org.example.java.model.Aluno;
import org.example.java.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
