package org.example.java.repository;

import org.example.java.model.Aluno;
import org.example.java.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProvaRepository extends JpaRepository<Prova, Long> {

}
