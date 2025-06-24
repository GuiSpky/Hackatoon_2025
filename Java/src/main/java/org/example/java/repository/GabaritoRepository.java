package org.example.java.repository;

import org.example.java.model.Gabarito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GabaritoRepository extends JpaRepository <Gabarito, Long> {

    List<Gabarito> findByAlunoId(Long alunoId);
}