package org.example.java.repository;

import org.example.java.model.Aluno;
import org.example.java.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
