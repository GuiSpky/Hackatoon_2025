package org.example.java.repository;

import org.example.java.model.Aluno;
import org.example.java.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProvaRepository extends JpaRepository<Prova, Long> {

    @Query("SELECT p FROM Prova p WHERE p.turma.id = :turmaId")
    List<Prova> findByTurmaId(@Param("turmaId") Long turmaId);

}
