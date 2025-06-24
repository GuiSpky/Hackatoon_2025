package org.example.java.repository;

import org.example.java.model.Gabarito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GabaritoRepository extends JpaRepository <Gabarito, Long> {
}